package com.example.pry.kotlind2.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by pry on 22/01/2018.
 */

@Module
class AppModule(private val app: Application) {
//    @Provides
//    @Singleton
//    fun provideContext(): Context = app
}