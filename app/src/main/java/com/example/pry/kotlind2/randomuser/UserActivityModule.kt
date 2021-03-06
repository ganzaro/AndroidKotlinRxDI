package com.example.pry.kotlind2.randomuser

import com.example.pry.kotlind2.di.NetworkModule
import dagger.Module
import dagger.Provides

/**
 * Created by pry on 26/01/2018.
 */
@Module
class UserActivityModule {

    @Provides
    fun provideMainView(activity: UserActivity): NetworkModule {
        return NetworkModule()
    }

//    @Provides
//    fun provideSingletonUtil(): SingletonUtil {
//        return SingletonUtil()
//    }
}