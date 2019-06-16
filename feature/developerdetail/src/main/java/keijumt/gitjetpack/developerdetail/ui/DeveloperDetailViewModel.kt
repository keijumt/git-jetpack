package keijumt.gitjetpack.developerdetail.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import keijumt.gitjetpack.data.repository.RepoRepository
import keijumt.gitjetpack.data.repository.UserRepository
import keijumt.gitjetpack.data.result.isError
import keijumt.gitjetpack.data.result.toSuccess
import keijumt.gitjetpack.model.Repo
import keijumt.gitjetpack.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeveloperDetailViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val repoRepository: RepoRepository
) : ViewModel() {

    private val _isVisibleProgress = MutableLiveData<Boolean>(true)
    val isVisibleProgress: LiveData<Boolean> = _isVisibleProgress

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _repos = MutableLiveData<List<Repo>>()
    val repos: LiveData<List<Repo>> = _repos

    fun loadProfile(userId: String) = viewModelScope.launch {
        _isVisibleProgress.value = true
        val userJob = async { withContext(Dispatchers.IO) { userRepository.detail(userId) } }
        val repoJob = async { withContext(Dispatchers.IO) { repoRepository.searchByUserId(userId) } }

        val userResult = userJob.await()
        val repoResult = repoJob.await()

        if (userResult.isError() or repoResult.isError()) {
            // TODO ErrorHandling
            return@launch
        }

        _user.value = userResult.toSuccess().data
        _repos.value = repoResult.toSuccess().data

        _isVisibleProgress.value = false
    }
}
