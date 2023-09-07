package com.ct.erp.config

import android.content.Context
import com.ct.erp.Constants
import com.king.frame.mvvmframe.config.AppliesOptions.OkHttpClientOptions
import com.king.frame.mvvmframe.config.FrameConfigModule
import com.king.frame.mvvmframe.di.module.ConfigModule
import okhttp3.OkHttpClient

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class AppConfigModule : FrameConfigModule() {
    override fun applyOptions(context: Context, builder: ConfigModule.Builder) {
        builder.baseUrl(Constants.BASE_URL)
                .okHttpClientOptions { clientBuilder ->
                    clientBuilder.addInterceptor { chain ->
                        chain.proceed(chain.request().newBuilder().apply {
                            header("Content-Type", "application/json")
                            header("x-kakao-webtoon-language", "zhc")
                            header("x-kakao-webtoon-platform", "AA")
                        }.build())
                    }
                }
    }
}