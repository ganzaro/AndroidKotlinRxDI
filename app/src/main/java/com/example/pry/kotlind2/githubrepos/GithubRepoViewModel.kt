package com.example.pry.kotlind2.githubrepos

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel
import com.example.pry.kotlind2.common.SchedulersFacade
import com.example.pry.kotlind2.common.states.Resource
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by pry on 04/02/2018.
 */

class GithubRepoViewModel @Inject constructor(
        private val githubRepoUseCase: GithubRepoUseCase,
        private val schedulersFacade: SchedulersFacade
        ): ViewModel() {

    private val disposables = CompositeDisposable()
//    private val repoResponse = MutableLiveData<GithubRepo>()
    val response = MutableLiveData<Resource<String>>()

//    init {
//        response.value = 0
//    }

    fun getUserInfo(username: String) = githubRepoUseCase.getUserInfo(username)

    fun getUserName() {
//        val tv = findViewById(R.id.textView) as TextView
        disposables.add(githubRepoUseCase.getUserInfo("pry")
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .subscribe(
                        { result -> response.value = (Resource.success(result.ownerName))},
                        { error -> response.value = (Resource.error(error)) }
                ))
    }

    fun getAllUserRepo(username: String) = githubRepoUseCase.getAllUserRepo(username)

    fun getAllRepo() = githubRepoUseCase.getAllRepo()

}