package com.rizz.test.core.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.rizz.test.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@GlideModule
class AppGlide : AppGlideModule()

@Module
@InstallIn(SingletonComponent::class)
class SingletonModule {
    /**
     * This function provides an Interceptor
     * All general APIs are using this interceptor
     * You can add later on the language, Bearer and any common header
     * to this interceptor
     * @return Interceptor
     */
    @Provides
    fun provideNetworkInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val builder = chain.request().newBuilder()
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept", "application/vnd.github+json")
            val request: Request = builder.build()
            chain.proceed(request)
        }
    }


    @Provides
    @Singleton
    @Named("hasNetwork")
    fun hasNetwork(context: Context): Boolean {
        var isConnected = false // Initial Value
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        isConnected =
            networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        return isConnected
    }

    /**
     * Provides default OkHttpClient
     * @param interceptor
     * @return
     */
    @Provides
    fun getOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

        val httpClient: OkHttpClient =
            builder.readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(loggingInterceptor)
                .build()

        return httpClient
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(
        okHttpClient: OkHttpClient,
    ): Retrofit.Builder {
        val baseUrl = "https://api.github.com/"
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
    }
}
