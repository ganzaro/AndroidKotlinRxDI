package com.example.pry.kotlind2.githubrepos

import com.example.pry.kotlind2.di.NetworkModule
import com.example.pry.kotlind2.common.SchedulersFacade
import com.example.pry.kotlind2.githubrepos.db.GithubUserDao
import dagger.Module
import dagger.Provides

/**
 * Created by pry on 26/01/2018.
 */
@Module
class GithubRepoActivityModule {

    @Provides
    fun provideMainView(activity: GithubRepoActivity): NetworkModule {
        return NetworkModule()
    }

    @Provides
    fun provideGithubRepository(githubApi: IGithubApi,
                                githubUserDao: GithubUserDao,
                                scheduler: SchedulersFacade): GithubRepository {
        return GithubRepository(githubApi, githubUserDao, scheduler)
    }

    @Provides
    fun provideViewModelFactory(useCase: GithubRepoUseCase,
                                scheduler: SchedulersFacade) :GithubRepoViewModelFactory {
        return GithubRepoViewModelFactory(useCase, scheduler)
    }
}


//@Provides
//fun provideLobbyViewModelFactory(loadCommonGreetingUseCase: LoadCommonGreetingUseCase,
//                                 loadLobbyGreetingUseCase: LoadLobbyGreetingUseCase,
//                                 schedulersFacade: SchedulersFacade): LobbyViewModelFactory {
//    return LobbyViewModelFactory(loadCommonGreetingUseCase, loadLobbyGreetingUseCase, schedulersFacade)
//}

//    @Provides
//    fun provideSingletonUtil(): SingletonUtil {
//        return SingletonUtil()
//    }