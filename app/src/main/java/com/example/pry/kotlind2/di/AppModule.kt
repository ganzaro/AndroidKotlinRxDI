package com.example.pry.kotlind2.di

import android.app.Application
import android.arch.persistence.room.Room
import com.example.pry.kotlind2.common.db.AppDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by pry on 22/01/2018.
 */

@Module
class AppModule {
//    @Provides
//    @Singleton
//    fun provideApp(): Application = app


    @Singleton
    @Provides
    fun room(app: Application): AppDb =
            Room.databaseBuilder(app, AppDb::class.java, "app_db").build()

    @Provides 
    fun providesGithubUserDao(database: AppDb) = database.githubUserDao()

}

/**
@Provides 
fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "my-todo-db").build()

@Provides 
fun providesToDoDao(database: AppDatabase) = database.taskDao()



@JvmStatic
@Provides
@Singleton
fun provideApplicationDataBase(application: Application): ApplicationDatabase {
    return Room.databaseBuilder(application, ApplicationDatabase::class.java, "fndr.db")
            .apply {
                if (Debug.isDebuggerConnected()) {
                    allowMainThreadQueries()
                }
                fallbackToDestructiveMigration()
            }.build()
}


*/



