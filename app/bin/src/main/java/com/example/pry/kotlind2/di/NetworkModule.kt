package com.example.pry.kotlind2.di

import com.example.pry.kotlind2.utils.Const
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by pry on 24/01/2018.
 */
@Module
class NetworkModule {

    companion object {
        private const val NAME_BASE_URL = "NAME_BASE_URL"
    }

    @Provides
    @Named(NAME_BASE_URL)
    fun provideBaseUrlString() = "${Const.PROTOCOL}://${Const.BASE_URL}"
//    fun provideBaseUrlString() = "${Const.PROTOCOL}://${Const.LANGUAGE}.${Const.BASE_URL}"


    @Provides
    @Singleton
    fun provideHttpClient() = OkHttpClient()

    @Provides
    @Singleton
    fun provideRequestBuilder(@Named(NAME_BASE_URL) baseUrl: String) =
            HttpUrl.parse(baseUrl)?.newBuilder()

//    @Provides
//    @Singleton
//    fun provideWikiApi(client: OkHttpClient, requestBuilder: HttpUrl.Builder?) = WikiApi(client, requestBuilder)
}