package com.combustela.combustela.di.modules

import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

@Module
class InterceptorModule {


    @NetworkLogger
    @Provides
    @IntoSet
    fun provideStetho(): Interceptor = StethoInterceptor()

    @NetworkLogger
    @Provides
    @IntoSet
    fun provideNetworkLogger(): Interceptor =
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }


}