package com.example.pry.kotlind2.githubrepos

import com.example.pry.kotlind2.di.NetworkModule
import dagger.Module
import dagger.Provides

/**
 * Created by pry on 26/01/2018.
 */
@Module
class GithubRepoActivityModule {

    @Provides
    fun provideMainView(activity: GithubRepoActivity): NetworkModule {
        return NetworkModule()
    }

//    @Provides
//    fun provideSingletonUtil(): SingletonUtil {
//        return SingletonUtil()
//    }
}