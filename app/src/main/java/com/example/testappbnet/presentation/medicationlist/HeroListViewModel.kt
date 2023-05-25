package com.example.testappbnet.presentation.medicationlist

import android.util.Log
import androidx.lifecycle.*
import com.example.testappbnet.domain.Hero
import com.example.testappbnet.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroListViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _result = MutableLiveData<List<Hero>>()
    val result: LiveData<List<Hero>>
        get() = _result

    fun refreshListOfHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            val tag = "HeroesList"
            Log.d(tag,"Вызван лаунчер")
            try {
                val resultList = repository.getHeroesList()
                Log.d(tag, resultList.toString())
                _result.postValue(resultList.heroesList)
            } catch (e: Throwable) {
                _error.postValue(e.message)
                Log.e(tag, e.stackTraceToString())
            }
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