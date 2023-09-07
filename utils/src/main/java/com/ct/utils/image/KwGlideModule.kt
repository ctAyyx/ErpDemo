package com.ct.utils.image

import android.content.Context
import android.os.Build
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.signature.ObjectKey
import com.ct.utils.BuildConfig
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient

import java.io.InputStream
import java.util.concurrent.TimeUnit

@GlideModule
class KwGlideModule : AppGlideModule() {

    private val expires = (System.currentTimeMillis() / (1000L * 60 * 60 * 24 * 30)).toString()

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setLogLevel(Log.ERROR)
        with(builder) {
            setMemorySizeCalculator(
                MemorySizeCalculator.Builder(context)
                        .setBitmapPoolScreens(1f)
                        .setMemoryCacheScreens(1f)
            )
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                setDefaultRequestOptions(
                    RequestOptions()
                            .signature(ObjectKey(expires))
                            .format(DecodeFormat.PREFER_RGB_565)
                            .disallowHardwareConfig()
                            .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                            .diskCacheStrategy(DiskCacheStrategy.DATA)
                            .skipMemoryCache(false)
                )
            } else {
                setDefaultRequestOptions(
                    RequestOptions()
                            .signature(ObjectKey(expires))
                            .format(DecodeFormat.PREFER_ARGB_8888)
                            .disallowHardwareConfig()
                            .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                            .diskCacheStrategy(DiskCacheStrategy.DATA)
                            .skipMemoryCache(false)
                )
            }
            if (BuildConfig.DEBUG)
                setLogLevel(Log.VERBOSE)
        }
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {

        val builder = OkHttpClient.Builder()
        builder.connectionPool(ConnectionPool(10, 3, TimeUnit.SECONDS))
                .connectTimeout(15L, TimeUnit.SECONDS)
                .readTimeout(15L, TimeUnit.SECONDS)
                .writeTimeout(15L, TimeUnit.SECONDS)
        registry.append(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(builder.build()))
    }

}