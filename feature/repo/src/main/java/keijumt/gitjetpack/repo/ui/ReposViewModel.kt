package keijumt.gitjetpack.repo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import keijumt.gitjetpack.data.repository.RepoRepository
import keijumt.gitjetpack.data.result.isError
import keijumt.gitjetpack.data.result.toSuccess
import keijumt.gitjetpack.model.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReposViewModel @Inject constructor(
    private val repoRepository: RepoRepository
) : ViewModel() {

    private val _isVisibleProgress = MutableLiveData<Boolean>(false)
    val isVisibleProgress: LiveData<Boolean> = _isVisibleProgress

    private val _repos = MutableLiveData<List<Repo>>()
    val repos: LiveData<List<Repo>> = _repos

    init {
        loadRepo("Kotlin")
    }

    fun onQueryTextSubmit(query: String): Boolean {
        loadRepo(query)
        return false
    }

    fun loadRepo(searchWord: String) = viewModelScope.launch {
        _isVisibleProgress.value = true

        withContext(Dispatchers.IO) {
            val result = repoRepository.searchByRepoName(searchWord)

            if (result.isError()) {
                // TODO ErrorHandling
                return@withContext
            }

            _repos.postValue(result.toSuccess().data)
        }

        _isVisibleProgress.value = false
    }
}