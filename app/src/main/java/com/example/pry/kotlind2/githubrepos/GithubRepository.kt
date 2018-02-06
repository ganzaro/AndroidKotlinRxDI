package com.example.pry.kotlind2.githubrepos


import android.util.Log
import com.example.pry.kotlind2.common.SchedulersFacade
import com.example.pry.kotlind2.githubrepos.db.GithubUserDao
import com.example.pry.kotlind2.githubrepos.dto.GithubUser
import com.example.pry.kotlind2.githubrepos.dto.GithubRepo
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by pry on 31/01/2018.
 */
class GithubRepository
    @Inject constructor(
            private val githubClient: IGithubApi,
            private val githubUserDao: GithubUserDao,
            private val schedulersFacade: SchedulersFacade) {


//    fun getUserInfo(username: String): Flowable<GithubUser> {
//        return githubClient.getUserInfo(username)
//                .doOnNext {
//                    storeUserInfoInDb(it)
//                }
//    }

    fun getUserInfo(username: String): Flowable<GithubUser> {
        return Flowable.concatArray(
                getUserInfoFromDb(username),
                getUserInfoFromApi(username)
        )
    }

    fun getUserInfoFromApi(username: String): Flowable<GithubUser> {
        return githubClient.getUserInfo(username)
                .doOnNext {
                    storeUserInfoInDb(it)
                }
    }

    fun getUserInfoFromDb(username: String): Flowable<GithubUser> {
        return githubUserDao.findUser(username)
                .doOnNext {  }
    }

    private fun storeUserInfoInDb(githubUser: GithubUser) {
        Flowable.fromCallable { githubUserDao.insert(githubUser) }
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.io())
                .subscribe {
//                    Log.d("save to db${githubUser.ownerName}")
                }
    }

    fun getAllUserRepo(username: String): Flowable<List<GithubRepo>> {
        return githubClient.getAllUserRepo(username)
    }

    fun getAllRepo(): Flowable<List<GithubRepo>> {
        return githubClient.getAllRepo()
    }

}



//
//
//class UserRepository @Inject constructor(private val userApiClient: IUserApi) {
//
//    fun getUser(): Observable<Result> {
//        return userApiClient.getUser()
//    }