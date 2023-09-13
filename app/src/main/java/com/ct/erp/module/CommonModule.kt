package com.ct.erp.module

import android.content.Context
import com.ct.erp.common.CommonPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 公共模块注入
 */
@InstallIn(SingletonComponent::class)
@Module
class CommonModule {

    @Singleton
    @Provides
    fun providerCommonPref(@ApplicationContext context: Context): CommonPref {
        return CommonPref(context)
    }


}