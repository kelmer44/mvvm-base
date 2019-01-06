package com.combustela.combustela.di.modules

import android.app.Application
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Rfc3339DateJsonAdapter
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(
        includes = [InterceptorModule::class]
)
class NetModule{




    @Provides
@Singleton
fun provideOkHttpClient(
            cache: Cache,
            @NetworkLogger
            interceptors: Set<@JvmSuppressWildcards Interceptor>) : OkHttpClient {


        var builder = OkHttpClient.Builder()
                .cache(cache)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
        interceptors.forEach {
            builder.addInterceptor(it)
        }

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient,
                        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
                        moshiConverterFactory: MoshiConverterFactory) : Retrofit {

        return Retrofit.Builder()
                .baseUrl("http://app.tussa.org/tussa/api/")
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(moshiConverterFactory)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideRxJavaCallAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory = MoshiConverterFactory.create(moshi)


    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
            .build()

    @Provides
    @Singleton
    fun provideOkHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024L
        return Cache(application.cacheDir, cacheSize)
    }
}
