package com.combustela.combustela.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.combustela.combustela.util.NetworkInteractor
import com.combustela.combustela.util.NetworkInteractorImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(
        includes = [Interceptors::class]
)

open class NetModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache, @NetworkLogger loggingInterceptors: Set<@JvmSuppressWildcards
    Interceptor>): OkHttpClient = OkHttpClient.Builder()
            .cache(cache)
            //TODO connectionPool patch until Okttp3 3.10 was on air
            .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
            .apply {
                loggingInterceptors.forEach {
                    addNetworkInterceptor(it)
                }
            }
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient,
                        rxJavaCallAdapterFactory: RxJava2CallAdapterFactory,
                        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://http://app.tussa.org/tussa/api/")
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideRxJavaCallAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideOkHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024L
        return Cache(application.getCacheDir(), cacheSize)
    }

    @Provides
    @Singleton
    fun provideConnectivityManager( context: Context): ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Provides
    @Singleton
    fun provideNetworkInteractor(networkInteractor: NetworkInteractorImpl): NetworkInteractor = networkInteractor



}