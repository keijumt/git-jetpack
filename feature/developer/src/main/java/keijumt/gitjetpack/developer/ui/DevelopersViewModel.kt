package keijumt.gitjetpack.developer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import keijumt.gitjetpack.common.util.SingleLiveEvent
import keijumt.gitjetpack.data.repository.UserRepository
import keijumt.gitjetpack.data.result.isError
import keijumt.gitjetpack.data.result.toSuccess
import keijumt.gitjetpack.model.Owner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DevelopersViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel(), DeveloperAdapterListener {

    private val _navigateToDeveloperDetail = SingleLiveEvent<String>()
    val navigateToDeveloperDetail: LiveData<String> = _navigateToDeveloperDetail

    private val _isVisibleProgress = MutableLiveData<Boolean>(false)
    val isVisibleProgress: LiveData<Boolean> = _isVisibleProgress

    private val _owner = MutableLiveData<List<Owner>>()
    val owner: LiveData<List<Owner>> = _owner

    init {
        loadUsers("a")
    }

    fun onQueryTextSubmit(query: String): Boolean {
        loadUsers(query)
        return false
    }

    fun loadUsers(searchWord: String) = viewModelScope.launch {
        _isVisibleProgress.value = true

        withContext(Dispatchers.IO) {
            val result = userRepository.search(searchWord)

            if (result.isError()) {
                // TODO ErrorHandling
                return@withContext
            }

            _owner.postValue(result.toSuccess().data)
        }

        _isVisibleProgress.value = false
    }

    override fun onClickItem(userId: String) {
        _navigateToDeveloperDetail.value = userId
    }
}