package com.example.pry.kotlind2.di

import com.example.pry.kotlind2.user.UserActivity
import com.example.pry.kotlind2.user.UserActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by pry on 26/01/2018.
 */


@Module abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules=arrayOf(UserActivityModule::class))
    abstract fun bindUserActivitiy(): UserActivity
}