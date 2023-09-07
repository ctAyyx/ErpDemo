package com.ct.utils.image

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapThumbnailImageViewTarget
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.bumptech.glide.request.transition.Transition
import com.ct.utils.SingletonHolder
import com.kakaopage.kakaowebtoon.framework.image.BitmapRequestListener
import com.kakaopage.kakaowebtoon.framework.image.ImageRequestListener
import java.util.concurrent.TimeUnit


/**
 * Created by erkas on 2017. 12. 26..
 *
 * glide v4 upgrade 2018. 2. 19
 */
class ImageManager private constructor() {
    companion object : SingletonHolder<ImageManager>(::ImageManager)

    enum class Type(val ext: String) {
        PNG(".png"), JPG(".jpg"), WEBP(".webp"), GIF(".gif"), NONE("")
    }
    private val defaultDownsampleStrategy: DownsampleType = DownsampleType.CENTER_INSIDE
    private val overrideWidth: Int = Target.SIZE_ORIGINAL
    private val overrideHeight: Int = Target.SIZE_ORIGINAL

    var useLowDensity: Boolean = false

    fun pauseRequests(context: Context?) {
        context?.let {
            Glide.with(it).pauseRequests()
        }

    }

    fun resumeRequests(context: Context?) {
        context?.let {
            Glide.with(it).resumeRequests()
        }
    }

    fun getRequest(context: Context? = null): RequestManager? {
        context ?: return null
        if (context is FragmentActivity) {
            return if (context.isDestroyed) null else Glide.with(context)
        }
        return Glide.with(context)
    }


    fun ensureImageUrl(imageUrl: String, imageType: Type = Type.WEBP): String {

        if (imageUrl.endsWith("jpg", true) || imageUrl.endsWith("png", true) || imageUrl.endsWith(
                    "jpeg", true
                ) || imageUrl.endsWith("webp", true) || imageUrl.endsWith("gif", true)
        ) {
            return imageUrl
        }


        return if (imageUrl.endsWith("~os", ignoreCase = true)) {
            "$imageUrl.a${imageType.ext}"
        } else {
            "$imageUrl${imageType.ext}"
        }
    }


    // extension function
    private fun RequestOptions.ensureDownsampling(
        downsampleType: DownsampleType, overrideWidth: Int, overrideHeight: Int
    ): RequestOptions {

        val width = when {
            Build.VERSION.SDK_INT < Build.VERSION_CODES.O -> 600
            overrideWidth <= 0 -> Target.SIZE_ORIGINAL
            overrideWidth > 4096 -> 4096
            else -> overrideWidth
        }

        val height = when {
            Build.VERSION.SDK_INT < Build.VERSION_CODES.O -> 600
            overrideHeight <= 0 -> Target.SIZE_ORIGINAL
            overrideHeight > 4096 -> 4096
            else -> overrideHeight
        }

        // NOTE. override(width, height) 의 값이 Target.SIZE_ORIGINAL 가 아닐 경우에만 동작한다.
        var sizeMultiplier = 1f
        if (useLowDensity) {
            sizeMultiplier = 0.5f
        }

        val downsampleStrategy = when (downsampleType) {
            DownsampleType.AT_MOST -> DownsampleStrategy.AT_MOST
            else -> DownsampleStrategy.CENTER_INSIDE
        }

        return this.downsample(downsampleStrategy).override(width, height).sizeMultiplier(sizeMultiplier)
    }

    private fun RequestOptions.diskCacheStrategy(diskCacheType: DiskCacheType): RequestOptions {
        val diskCacheStrategy = when (diskCacheType) {
            DiskCacheType.DATA -> DiskCacheStrategy.DATA
            DiskCacheType.NONE -> DiskCacheStrategy.NONE
            else -> DiskCacheStrategy.ALL
        }

        return diskCacheStrategy(diskCacheStrategy)
    }

    private fun loadImage(
        imageUrl: String?,
        imageType: Type = Type.WEBP,
        skipMemoryCache: Boolean = false,
        diskCacheStrategy: DiskCacheType = DiskCacheType.DATA,
        listener: ImageRequestListener? = null
    ): RequestBuilder<Drawable>? {
        if (imageUrl.isNullOrEmpty()) {
            return null
        }

        val glide = getRequest()?.load(ensureImageUrl(imageUrl, imageType)) ?: return null
        var requestOptions = RequestOptions().diskCacheStrategy(diskCacheStrategy)
                .ensureDownsampling(defaultDownsampleStrategy, overrideWidth, overrideHeight)

        if (skipMemoryCache) {
            requestOptions = requestOptions.skipMemoryCache(skipMemoryCache)
        }


        return glide.apply(requestOptions).listener(object : RequestListener<Drawable> {
            override fun onResourceReady(
                resource: Drawable,
                model: Any,
                target: Target<Drawable>?,
                dataSource: DataSource,
                isFirstResource: Boolean
            ): Boolean {
                listener?.onResourceReady(resource)
                return false
            }

            override fun onLoadFailed(
                e: GlideException?, model: Any?, target: Target<Drawable>, isFirstResource: Boolean
            ): Boolean {
                listener?.onLoadFailed(e)
                if (e != null) {
                    return true
                }
                return false
            }
        })
    }

    fun preLoadImage(
        imageUrl: String?,
        imageType: Type = Type.WEBP,
        context: Context? = null,
        diskCacheStrategy: DiskCacheType = DiskCacheType.DATA,
        downsampleStrategy: DownsampleType = DownsampleType.CENTER_INSIDE,
        overrideWidth: Int = Target.SIZE_ORIGINAL,
        overrideHeight: Int = Target.SIZE_ORIGINAL
    ) {

        if (imageUrl.isNullOrEmpty()) {
            return
        }

        val request = getRequest(context) ?: return
        request.load(ensureImageUrl(imageUrl, imageType)).apply(
            RequestOptions().diskCacheStrategy(diskCacheStrategy)
                    .ensureDownsampling(downsampleStrategy, overrideWidth, overrideHeight)
        ).preload()
    }


    fun loadImageIntoImageView(
        imageUrl: String?,
        targetView: ImageView?,
        imageType: Type = Type.WEBP,
        diskCacheStrategy: DiskCacheType = DiskCacheType.DATA,
        downsampleStrategy: DownsampleType = DownsampleType.CENTER_INSIDE,
        overrideWidth: Int = Target.SIZE_ORIGINAL,
        overrideHeight: Int = Target.SIZE_ORIGINAL,
        transform: BlurTransformation? = null,
        @DrawableRes placeholder: Int = 0,
        @DrawableRes error: Int = 0,
        dontTransition: Boolean = false,
        fadeInTransition: Boolean = false,
        thumbnailSizeMultiplier: Float = 1f,
        thumbnailUrl: String? = null,
        thumbnailListener: ImageRequestListener? = null,
        skipMemoryCache: Boolean = false,
        gifLoopCount: Int = 10, // GifDrawable.LOOP_FOREVER
        finally: ((loadSuccess: Boolean, resource: Drawable?) -> Unit)? = null
    ) {
        targetView ?: return

        if (imageUrl.isNullOrEmpty()) {
            targetView.setImageResource(0)
            finally?.invoke(false, null)
            return
        }

        val request = getRequest(targetView.context) ?: return
        var glide = request.load(ensureImageUrl(imageUrl, imageType))
        var requestOptions = RequestOptions().diskCacheStrategy(diskCacheStrategy)
                .ensureDownsampling(downsampleStrategy, overrideWidth, overrideHeight)


        if (skipMemoryCache) {
            // glide v4 에서 메모리캐쉬 사용시 gif 재생이 pause/resume 동작이 적용된다.
            // 따라서 gif 를 무조건 처음부터 재생시키려면 메모리 캐쉬를 꺼야만 한다.
            requestOptions = requestOptions.skipMemoryCache(skipMemoryCache)
        }

        if (error != 0) {
            requestOptions = requestOptions.error(error)
        }

        if (placeholder != 0) {
            requestOptions = requestOptions.placeholder(placeholder)
        }

        if (dontTransition) {
            glide = glide.transition(WebtoonTransitionOptions().dontTransition())
        } else if (fadeInTransition) {
            val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
            glide = glide.transition(DrawableTransitionOptions.withCrossFade(factory))
        }


        transform?.let { requestOptions = requestOptions.transform(it) }

        var requestBuilder = glide.apply(requestOptions)

        if (thumbnailSizeMultiplier != 1f) {
            requestBuilder = requestBuilder.thumbnail(thumbnailSizeMultiplier)
        }

        thumbnailUrl?.run {
            requestBuilder = requestBuilder.thumbnail(
                loadImage(
                    thumbnailUrl, skipMemoryCache = skipMemoryCache, listener = thumbnailListener
                )
            )
        }
        requestBuilder.into(object : DrawableImageViewTarget(targetView) {
            override fun onLoadFailed(errorDrawable: Drawable?) {
                super.onLoadFailed(errorDrawable)
                Handler(Looper.getMainLooper()).post {
                    finally?.invoke(false, errorDrawable)
                }
            }

            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                super.onResourceReady(resource, transition)
                if (resource is GifDrawable && gifLoopCount > 0) {
                    resource.setLoopCount(gifLoopCount)
                }
                finally?.invoke(true, resource)
            }
        })

    }

    fun loadBitmapIntoImageView(
        imageUrl: String?,
        targetView: ImageView?,
        imageType: Type = Type.WEBP,
        diskCacheStrategy: DiskCacheType = DiskCacheType.DATA,
        sizeMultiplier: Float = 1f,
        transform: BlurTransformation? = null,
        isCircleCrop: Boolean = false,
        @DrawableRes error: Int = 0,
        @DrawableRes placeholder: Int = 0,
        failure: (() -> Unit)? = null,
        function: (() -> Unit)? = null
    ) {
        targetView ?: return
        if (imageUrl.isNullOrEmpty()) {
            targetView.setImageResource(error)
            return
        }

        val request = getRequest(targetView.context) ?: return
        val glide = request.asBitmap().load(ensureImageUrl(imageUrl, imageType))

        var requestOptions = RequestOptions().diskCacheStrategy(diskCacheStrategy)
                .ensureDownsampling(defaultDownsampleStrategy, overrideWidth, overrideHeight)

        if (sizeMultiplier < 1f) {
            requestOptions = requestOptions.sizeMultiplier(sizeMultiplier)
        }

        if (error != 0) {
            requestOptions = requestOptions.error(error)
        }

        if (placeholder != 0) {
            requestOptions = requestOptions.placeholder(placeholder)
        }

        if (isCircleCrop) {
            requestOptions = requestOptions.circleCrop()
        }

        transform?.let { requestOptions = requestOptions.transform(it) }

        val requestBuilder = glide.apply(requestOptions)

        if (function == null && failure == null) {
            requestBuilder.into(targetView)
        } else {
            requestBuilder.into(object : BitmapThumbnailImageViewTarget(targetView) {
                override fun onLoadFailed(errorDrawable: Drawable?) {
                    super.onLoadFailed(errorDrawable)

                    if (failure != null) {
                        failure()
                    }
                }

                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    super.onResourceReady(resource, transition)

                    if (function != null) {
                        function()
                    }
                }
            })
        }
    }

    fun loadBitmap(
        imageUrl: String?,
        imageType: Type = Type.WEBP,
        diskCacheStrategy: DiskCacheType = DiskCacheType.DATA,
        sizeMultiplier: Float = 1f,
        onlyCache: Boolean = false,
        overrideWidth: Int = 0,
        overrideHeight: Int = 0,
        failure: (() -> Unit)? = null,
        function: ((Bitmap) -> Unit)? = null
    ) {

        if (imageUrl.isNullOrEmpty()) {
            failure?.invoke()
            return
        }
        val request = getRequest() ?: return
        val glide = request.asBitmap().load(ensureImageUrl(imageUrl, imageType)).let {
            if (overrideWidth > 0 && overrideHeight > 0) it.override(overrideWidth, overrideHeight)
            else it
        }


        var requestOptions = RequestOptions().diskCacheStrategy(diskCacheStrategy)
                .ensureDownsampling(defaultDownsampleStrategy, overrideWidth, overrideHeight)

        if (sizeMultiplier < 1f) {
            requestOptions = requestOptions.sizeMultiplier(sizeMultiplier)
        }

        if (onlyCache) {
            requestOptions = requestOptions.onlyRetrieveFromCache(true)
        }
        val requestBuilder = glide.apply(requestOptions)

        if (function == null && failure == null) {
            requestBuilder.preload()
        } else {
            requestBuilder.addListener(object : RequestListener<Bitmap> {
                override fun onLoadFailed(
                    e: GlideException?, model: Any?, target: Target<Bitmap>, isFirstResource: Boolean
                ): Boolean {
                    if (failure != null) {
                        failure()
                        return true
                    }
                    return false
                }

                override fun onResourceReady(
                    resource: Bitmap,
                    model: Any,
                    target: Target<Bitmap>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    if (function != null) {
                        function(resource)
                        return true
                    }
                    return false
                }

            }).preload()
        }
    }

    fun loadGifIntoImageView(@DrawableRes imageRes: Int, targetView: ImageView) {
        val request = getRequest(targetView.context) ?: return
        request.asGif().load(imageRes).into(targetView)
    }

    fun loadImageIntoDrawable(
        context: Context?, imageUrl: String?, imageType: Type = Type.JPG, function: (d: Drawable?) -> Unit
    ) {
        val request = getRequest(context) ?: return
        request.asDrawable().load("$imageUrl${imageType.ext}").into(object : CustomTarget<Drawable>() {
            override fun onResourceReady(
                resource: Drawable, transition: Transition<in Drawable>?
            ) {
                function(resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {}

            override fun onLoadFailed(errorDrawable: Drawable?) {
                function(null)
                super.onLoadFailed(errorDrawable)
            }

        })
    }

    fun loadImageIntoDrawable(
        context: Context?,
        imageUrl: String?,
        imageType: Type = Type.JPG,
        width: Int,
        height: Int,
        function: (d: Drawable?) -> Unit
    ) {
        val request = getRequest(context) ?: return
        request.asDrawable().override(width, height).load("$imageUrl${imageType.ext}")
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(
                        resource: Drawable, transition: Transition<in Drawable>?
                    ) {
                        function(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}

                    override fun onLoadFailed(errorDrawable: Drawable?) {
                        function(null)
                        super.onLoadFailed(errorDrawable)
                    }

                })
    }


    fun loadAnimateWebpIntoImageView(@DrawableRes imageRes: Int, targetView: ImageView?) {
        targetView ?: return
        val request = getRequest(targetView.context) ?: return
        request.asDrawable().load(imageRes).into(object : CustomViewTarget<ImageView, Drawable>(targetView) {
            override fun onLoadFailed(errorDrawable: Drawable?) {}

            override fun onResourceReady(
                resource: Drawable, transition: Transition<in Drawable>?
            ) {
                targetView.setImageDrawable(resource)
                if (resource is Animatable) {
                    resource.start()
                }
            }

            override fun onResourceCleared(placeholder: Drawable?) {}
        })

    }


    fun loadBitmapCutting(
        imageUrl: String?,
        imageType: Type = Type.WEBP,
        context: Context? = null,
        skipMemoryCache: Boolean = false,
        diskCacheStrategy: DiskCacheType = DiskCacheType.DATA,
        listener: BitmapRequestListener? = null
    ) {

        if (imageUrl.isNullOrEmpty()) {
            return
        }

        val bitmapList = ArrayList<Bitmap>()
        val request = getRequest(context) ?: return
        request.asBitmap().load(ensureImageUrl(imageUrl, imageType)).apply(
            RequestOptions().diskCacheStrategy(diskCacheStrategy).skipMemoryCache(skipMemoryCache)
                    .ensureDownsampling(defaultDownsampleStrategy, overrideWidth, overrideHeight)

        ).listener(object : RequestListener<Bitmap> {
            override fun onLoadFailed(
                e: GlideException?, model: Any?, target: Target<Bitmap>, isFirstResource: Boolean
            ): Boolean {
                return false
            }

            override fun onResourceReady(
                bitmap: Bitmap, model: Any, target: Target<Bitmap>?, dataSource: DataSource, isFirstResource: Boolean
            ): Boolean {
                val resultBitmapWidth = bitmap.width / 10
                val resultBitmapHeight = bitmap.height
                for (i in 1..10) {
                    val result: Bitmap = Bitmap.createBitmap(
                        bitmap, resultBitmapWidth * (i - 1), 0, resultBitmapWidth, resultBitmapHeight
                    )
                    bitmapList.add(result)
                }
                listener?.onResourceReady(bitmapList)

                return false
            }
        }).preload()
    }


    fun clear(view: View?) {
        view?.run {
            val context = context
            if (context == null || (context is Activity && context.isDestroyed)) {
                return@run
            }

            Glide.get(context).requestManagerRetriever.get(this).clear(view)
        }
    }

    fun onLowMemory(context: Context?) {
        context ?: return
        Glide.get(context).onLowMemory()
    }

    fun onTrimMemory(context: Context?, level: Int) {
        context ?: return
        Glide.get(context).trimMemory(level)
    }

    fun clearCache(context: Context?) {
        context ?: return
        AsyncTask.execute {
            Glide.get(context).clearDiskCache()
        }
        Glide.get(context).clearMemory()
    }

    fun checkImageCache(context: Context?, url: String): Boolean {
        if (url.isBlank()) {
            return false
        }
        context ?: return false
        val futureTarget = Glide.with(context).load(ensureImageUrl(url)).submit()
        try {
            futureTarget.get(300L, TimeUnit.MILLISECONDS)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return false
    }

    fun loadCropBitmap(
        context: Context, uri: Uri, maxWidth: Int, maxHeight: Int, result: ((Bitmap?) -> Unit)? = null
    ) {
        val request = getRequest(context) ?: return
        request.asBitmap().load(uri).override(maxWidth, maxHeight).into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                result?.invoke(resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                result?.invoke(null)
            }
        })
    }

    fun loadVideoImage(
        context: Context,
        frameTime: Long,
        url: String,
        targetView: ImageView?,
        transform: BlurTransformation? = null,
    ) {
        if (targetView == null) return
        var requestOptions = RequestOptions().frame(frameTime)
        if (transform != null) requestOptions = requestOptions.transform(transform)
        val request = getRequest(context) ?: return
        request.setDefaultRequestOptions(requestOptions).load(url).into(targetView)
    }

}