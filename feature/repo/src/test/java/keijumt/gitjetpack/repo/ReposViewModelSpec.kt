package keijumt.gitjetpack.repo

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.lifecycle.Observer
import io.kotlintest.Spec
import io.kotlintest.specs.ShouldSpec
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifySequence
import keijumt.gitjetpack.data.repository.RepoRepository
import keijumt.gitjetpack.data.result.Result
import keijumt.gitjetpack.model.Repo
import keijumt.gitjetpack.repo.ui.ReposViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

class ReposViewModelSpec : ShouldSpec() {

    override fun beforeSpec(spec: Spec) {
        super.beforeSpec(spec)
        Dispatchers.setMain(Dispatchers.Unconfined)
        ArchTaskExecutor.getInstance().setDelegate(InstantTaskExecutor)
    }

    override fun afterSpec(spec: Spec) {
        super.afterSpec(spec)
        ArchTaskExecutor.getInstance().setDelegate(null)
        Dispatchers.resetMain()
    }

    init {
        "loadRepo" {
            "repository successfully returns" {
                val repoRepository = mockk<RepoRepository>()
                coEvery { repoRepository.searchByRepoName(any()) } returns Result.Success(emptyList())
                val viewModel = ReposViewModel(repoRepository)
                val reposObserver = mockk<Observer<List<Repo>>>(relaxed = true)
                val visibleProgressObserver = mockk<Observer<Boolean>>(relaxed = true)

                viewModel.repos.observeForever(reposObserver)
                viewModel.isVisibleProgress.observeForever(visibleProgressObserver)

                runBlocking { viewModel.loadRepo("kotlin").join() }

                should("repoRepository.searchByRepoName() is called") {
                    coVerify { repoRepository.searchByRepoName("kotlin") }
                }

                should("visible switches") {
                    verifySequence {
                        visibleProgressObserver.onChanged(false)
                        visibleProgressObserver.onChanged(true)
                        visibleProgressObserver.onChanged(false)
                    }
                }

                should("value flows to repos livedata") {
                    verify { reposObserver.onChanged(any()) }
                }
            }
            "repository returns an error" {
                val repoRepository = mockk<RepoRepository>()
                coEvery { repoRepository.searchByRepoName(any()) } returns Result.Error(Exception())
                val viewModel = ReposViewModel(repoRepository)
                val reposObserver = mockk<Observer<List<Repo>>>(relaxed = true)
                val visibleProgressObserver = mockk<Observer<Boolean>>(relaxed = true)

                viewModel.repos.observeForever(reposObserver)
                viewModel.isVisibleProgress.observeForever(visibleProgressObserver)

                runBlocking { viewModel.loadRepo("kotlin").join() }

                should("repoRepository.searchByRepoName() is called") {
                    coVerify { repoRepository.searchByRepoName("kotlin") }
                }

                should("visible switches") {
                    verifySequence {
                        visibleProgressObserver.onChanged(false)
                        visibleProgressObserver.onChanged(true)
                        visibleProgressObserver.onChanged(false)
                    }
                }

                should("value no flows to repos livedata") {
                    verify(exactly = 0) { reposObserver.onChanged(any()) }
                }
            }
        }
    }
}