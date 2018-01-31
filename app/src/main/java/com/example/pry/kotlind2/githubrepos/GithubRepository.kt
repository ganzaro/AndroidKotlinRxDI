package com.example.pry.kotlind2.githubrepos


import com.example.pry.kotlind2.githubrepos.dto.GithubOwner
import com.example.pry.kotlind2.githubrepos.dto.GithubRepo
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by pry on 31/01/2018.
 */
class GithubRepository @Inject constructor(private val githubClient: IGithubApi) {

    fun getAllRepo(): Observable<List<GithubRepo>> {
        return githubClient.getAllRepo()
    }

    fun getUserInfo(username: String): Observable<GithubOwner> {
        return githubClient.getUserInfo(username)
    }

    fun getAllUserRepo(username: String): Observable<List<GithubRepo>> {
        return githubClient.getAllUserRepo(username)
    }

}



//
//
//class UserRepository @Inject constructor(private val userApiClient: IUserApi) {
//
//    fun getUser(): Observable<Result> {
//        return userApiClient.getUser()
//    }