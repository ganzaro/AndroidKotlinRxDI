package com.example.pry.kotlind2

import android.app.Activity
import android.app.Application
import com.example.pry.kotlind2.di.AppComponent
import com.example.pry.kotlind2.di.AppModule
import com.example.pry.kotlind2.di.DaggerAppComponent
import com.example.pry.kotlind2.di.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by pry on 22/01/2018.
 */



class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}
