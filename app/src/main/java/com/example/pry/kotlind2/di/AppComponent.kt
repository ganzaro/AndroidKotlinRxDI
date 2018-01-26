package com.example.pry.kotlind2.di

import android.app.Application
import com.example.pry.kotlind2.App
import com.example.pry.kotlind2.user.UserActivity
import dagger.BindsInstance
import dagger.Component
//import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by pry on 22/01/2018.
 */
//
@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class
])

interface AppComponent {
//    fun application(): Application
    fun inject(target: UserActivity)
}


//@Singleton
//@Component(modules = arrayOf(
//        AndroidInjectionModule::class,
//        AppModule::class,
//        NetworkModule::class,
//        ActivityBuilder::class))
//
//interface AppComponent {
//
//    @Component.Builder
//    interface Builder {
//
//        @BindsInstance
//        fun application(application: Application): Builder
//
//        fun build(): AppComponent
//    }
//
//    fun inject(app: App)
//}