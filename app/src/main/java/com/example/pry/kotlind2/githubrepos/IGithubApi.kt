package com.example.pry.kotlind2.githubrepos

import com.example.pry.kotlind2.githubrepos.dto.GithubUser
import com.example.pry.kotlind2.githubrepos.dto.GithubRepo
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by pry on 31/01/2018.
 */
interface IGithubApi {

    @GET("repositories")
    fun getAllRepo() : Flowable<List<GithubRepo>>

    @GET("users/{username}")
    fun getUserInfo(@Path("username") username: String): Flowable<GithubUser>

    @GET("users/{username}/repos")
    fun getAllUserRepo(@Path("username") username: String): Flowable<List<GithubRepo>>

}

//
//interface IGithubApi {
//
//    @GET("repositories")
//    fun getAllRepo() : Call<List<GithubRepository>>
//
//    @GET("users/{username}")
//    fun getUserInfo(@Path("username") username: String): Call<GithubUser>
//
//    @GET("users/{username}/repos")
//    fun getAllUserRepo(@Path("username") username: String): Call<List<GithubRepo>>
//
//}