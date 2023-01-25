package com.pratik.catchywall.di

import com.pratik.catchywall.data.remote.NetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CatchyAppModel {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl(NetworkApi.BASE_URL).client(
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    ).addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun getNetworkApi(retrofit: Retrofit): NetworkApi = retrofit.create(NetworkApi::class.java)

}