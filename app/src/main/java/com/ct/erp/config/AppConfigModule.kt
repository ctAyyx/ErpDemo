package com.ct.erp.config

import android.content.Context
import com.ct.erp.common.Constants
import com.ct.erp.common.LoginManager
import com.king.frame.mvvmframe.config.FrameConfigModule
import com.king.frame.mvvmframe.di.module.ConfigModule

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class AppConfigModule : FrameConfigModule() {
    override fun applyOptions(context: Context, builder: ConfigModule.Builder) {
        builder.baseUrl(Constants.BASE_URL).okHttpClientOptions { clientBuilder ->
            clientBuilder.addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().apply {
                    header("Content-Type", "application/json")
                    if (LoginManager.getInstance().isLogin()) {
                        header("Token", LoginManager.getInstance().token)
                    }
                }.build())
            }
        }
    }

}