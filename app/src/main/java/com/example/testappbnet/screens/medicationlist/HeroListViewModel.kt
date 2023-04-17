package com.example.testappbnet.screens.medicationlist

import androidx.lifecycle.*
import com.example.testappbnet.data.repository.Repository
import com.example.testappbnet.models.Hero
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroListViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _result = MutableLiveData<List<Hero>>()
    val result : LiveData<List<Hero>>
        get() = _result

    fun refreshListOfHeroes() {
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
            throwable.printStackTrace()
        }
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            _result.value = repository.getHeroesList()
        }
    }

    @Suppress("UNCHECKED_CAST")
    class MedicationListVMFactory(
        private val repository: Repository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            HeroListViewModel(repository) as T
    }

}