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

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    private fun initDagger(app: App): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
}


//class App : Application() {
////    companion object {
////        lateinit var appComponent: AppComponent
////    }
//
//    lateinit var appComponent: AppComponent
//
//    override fun onCreate() {
//        super.onCreate()
//        appComponent= DaggerAppComponent.builder()
//                .networkModule(NetworkModule())
//                .appModule(AppModule(this))
//                .build()
//    }
//}

//class App : Application(), HasActivityInjector {
//
//    @Inject
//    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
//
//    override fun onCreate() {
//        super.onCreate()
//        DaggerAppComponent
//                .builder()
//                .application(this)
//                .build()
//                .inject(this)
//    }
//
//    override fun activityInjector(): AndroidInjector<Activity> {
//        return activityDispatchingAndroidInjector
//    }
//}
