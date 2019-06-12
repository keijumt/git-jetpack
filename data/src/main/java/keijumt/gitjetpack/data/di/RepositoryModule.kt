package keijumt.gitjetpack.data.di

import dagger.Module
import dagger.Provides
import keijumt.gitjetpack.data.api.GithubService
import keijumt.gitjetpack.data.repository.RepoRepository
import keijumt.gitjetpack.data.repository.RepoRepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepoRepository(githubService: GithubService): RepoRepository {
        return RepoRepositoryImpl(githubService)
    }
}