package keijumt.gitjetpack.developer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
) : ViewModel() {

    private val _isVisibleProgress = MutableLiveData<Boolean>(false)
    val isVisibleProgress: LiveData<Boolean> = _isVisibleProgress

    private val _owner = MutableLiveData<List<Owner>>()
    val owner: LiveData<List<Owner>> = _owner

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

    init {
        viewModelScope.launch {
            val hoge = userRepository.search("keijumt")
            println("hoge size is ${hoge.toSuccess().data.size}")
        }
    }
}