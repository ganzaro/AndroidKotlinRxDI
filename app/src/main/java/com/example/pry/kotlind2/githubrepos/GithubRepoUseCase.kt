package com.example.pry.kotlind2.githubrepos

import com.example.pry.kotlind2.githubrepos.dto.GithubUser
import com.example.pry.kotlind2.githubrepos.dto.GithubRepo
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject
/**
 * Created by pry on 04/02/2018.
 */

class GithubRepoUseCase @Inject constructor(private val repo: GithubRepository) {

    fun getUserInfo(username: String) :Flowable<GithubUser> {
        return repo.getUserInfo(username)
    }

    fun getAllRepo(): Flowable<List<GithubRepo>> {
        return repo.getAllRepo()
    }

    fun getAllUserRepo(username: String): Flowable<List<GithubRepo>> {
        return repo.getAllUserRepo(username)
    }
}

// class GithubRepository @Inject constructor(private val githubClient: IGithubApi) {


//internal class LoadLobbyGreetingUseCase @Inject
//constructor(private val greetingRepository: LobbyGreetingRepository) : LoadGreetingUseCase {
//
//    fun execute(): Single<String> {
//        return greetingRepository.getGreeting()
//    }
//}