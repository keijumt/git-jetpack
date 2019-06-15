package keijumt.gitjetpack.data.di

import dagger.Module
import dagger.Provides
import keijumt.gitjetpack.data.api.GithubService
import keijumt.gitjetpack.data.repository.RepoRepository
import keijumt.gitjetpack.data.repository.RepoRepositoryImpl
import keijumt.gitjetpack.data.repository.UserRepository
import keijumt.gitjetpack.data.repository.UserRepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepoRepository(githubService: GithubService): RepoRepository {
        return RepoRepositoryImpl(githubService)
    }

    @Singleton
    @Provides
    fun provideUserRepository(githubService: GithubService): UserRepository {
        return UserRepositoryImpl(githubService)
    }
}