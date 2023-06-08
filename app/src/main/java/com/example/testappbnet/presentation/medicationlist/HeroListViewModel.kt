package com.example.testappbnet.presentation.medicationlist

import android.os.Parcelable
import androidx.lifecycle.*
import com.example.testappbnet.domain.Repository
import com.example.testappbnet.domain.models.Hero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroListViewModel(
    private val repository: Repository,
) : ViewModel() {

    private lateinit var state: Parcelable

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _result = MutableLiveData<List<Hero>>()
    val result: LiveData<List<Hero>>
        get() = _result

    fun refreshListOfHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val resultList = repository.getHeroesList()
                _result.postValue(resultList.heroesList)
            } catch (e: Throwable) {
                _error.postValue(e.message)
            }
        }
    }

    fun saveRecyclerViewState(parcelable: Parcelable) { state = parcelable }

    fun restoreRecyclerViewState() : Parcelable = state

    fun stateInitialized() : Boolean = ::state.isInitialized

    @Suppress("UNCHECKED_CAST")
    class MedicationListVMFactory(
        private val repository: Repository,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            HeroListViewModel(repository) as T
    }

}