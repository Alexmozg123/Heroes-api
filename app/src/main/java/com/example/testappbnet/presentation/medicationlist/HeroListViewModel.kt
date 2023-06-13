package com.example.testappbnet.presentation.medicationlist

import androidx.lifecycle.*
import com.example.testappbnet.domain.Repository
import com.example.testappbnet.domain.models.Hero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroListViewModel(
    private val repository: Repository,
) : ViewModel() {

    private var heroes = mutableListOf<Hero>()
    private val _result = MutableLiveData<List<Hero>>()
    val result: LiveData<List<Hero>>
        get() = _result

    fun refreshListOfHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getHeroesList().also {
                heroes.clear()
                heroes.addAll(it.heroesList)
            }
            _result.postValue(heroes)
        }
    }

    fun onTextChanged(text: String) {
        val filterList: MutableList<Hero> = ArrayList()
        for (item in heroes) {
            if (item.name.contains(text)) {
                filterList.add(item)
            }
        }
        _result.postValue(filterList)
    }

    @Suppress("UNCHECKED_CAST")
    class HeroesListVMFactory(
        private val repository: Repository,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            HeroListViewModel(repository) as T
    }
}