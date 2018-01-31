package com.example.pry.kotlind2.di

import com.example.pry.kotlind2.randomuser.IUserApi
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Rfc3339DateJsonAdapter
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Singleton

/**
 * Created by pry on 24/01/2018.
 */
@Module
class NetworkModule {

//    companion object {
//        private const val NAME_BASE_URL = "NAME_BASE_URL"
//    }
//
//    @Provides
//    @Named(NAME_BASE_URL)
//    fun provideBaseUrlString() = "${Const.PROTOCOL}://${Const.BASE_URL}"



    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(interceptor: HttpLoggingInterceptor) = OkHttpClient.Builder().addInterceptor(interceptor).build()


//    @Provides
//    @Singleton
//    fun provideRequestBuilder(@Named(NAME_BASE_URL) baseUrl: String) =
//            HttpUrl.parse(baseUrl)?.newBuilder()

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
                .build()
    }

    @Provides
    @Singleton
    fun providesRetroBuilder(client: OkHttpClient, moshi: Moshi): Retrofit {
        val BASE_URL = "https://randomuser.me/api/"

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .baseUrl(BASE_URL)
                .build()
    }

    @Provides
    @Singleton
    fun provideUserApi(retro: Retrofit): IUserApi {
        return retro.create(IUserApi::class.java)
    }





//    @Provides
//    @Singleton
//    fun provideUserApi(client: OkHttpClient, requestBuilder: HttpUrl.Builder?) = IUserApi(client, requestBuilder)
    /**
     *
    @Provides
    @Singleton
    RestAdapter provideRestAdapter() {
    return new RestAdapter.Builder()
    .setEndpoint("http://eu.battle.net/api")
    .setLogLevel(RestAdapter.LogLevel.FULL)
    .build();

    }*/

}

// {"results":[{"gender":"male","name":{"title":"mr","first":"andrew","last":"horton"},"nat":"IE"}],"info":{"seed":"7dcb738985b546df","results":1,"page":1,"version":"1.1"}}
