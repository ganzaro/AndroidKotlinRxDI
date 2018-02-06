package com.example.pry.kotlind2.common.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.pry.kotlind2.githubrepos.db.GithubUserDao
import com.example.pry.kotlind2.githubrepos.dto.GithubUser

/**
 * Created by pry on 05/02/2018.
 */

@Database(entities = arrayOf(GithubUser::class), version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun githubUserDao(): GithubUserDao
}


/**
 *
@Database(entities = [Event::class], version = 2, exportSchema = false)
@TypeConverters(RoomOffsetDateTimeConverter::class)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun eventsDao(): EventsDao
}

 */
