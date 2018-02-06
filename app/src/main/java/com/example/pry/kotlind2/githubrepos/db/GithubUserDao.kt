package com.example.pry.kotlind2.githubrepos.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.pry.kotlind2.githubrepos.dto.GithubUser
import io.reactivex.Flowable

/**
 * Created by pry on 05/02/2018.
 */
@Dao
interface GithubUserDao {
    @Query("SELECT * FROM GithubUser WHERE ownerName = :name LIMIT 1")
    fun findUser(name: String): Flowable<GithubUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: GithubUser)

}


/*
interface RoomUserDao {

    @Query("SELECT * FROM Users")
    fun allUsers(): Flowable<List<UserEntity>>

    @Query("SELECT * FROM Users WHERE name = :name LIMIT 1")
    fun findUser(name: String): Flowable<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repositories: List<RepositoryEntity>)

    @Query("SELECT * FROM Repositories WHERE userId = :userId")
    fun findRepositoriesForUser(userId: Long): Flowable<List<RepositoryEntity>>

}
 */