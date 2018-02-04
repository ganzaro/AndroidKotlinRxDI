package com.example.pry.kotlind2.githubrepos

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.pry.kotlind2.common.SchedulersFacade

/**
 * Created by pry on 04/02/2018.
 */

class GithubRepoViewModelFactory(
        private val githubRepoUseCase: GithubRepoUseCase,
        private val schedulersFacade: SchedulersFacade
        ): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(GithubRepoViewModel::class.java)) {
            return GithubRepoViewModel(githubRepoUseCase, schedulersFacade) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}