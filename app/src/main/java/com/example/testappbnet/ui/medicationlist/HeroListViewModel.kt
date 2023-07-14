package com.example.testappbnet.ui.medicationlist

import androidx.lifecycle.*
import com.example.testappbnet.domain.HeroInteractor
import com.example.testappbnet.domain.models.Hero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HeroListViewModel @Inject constructor(
    private val heroInteractor: HeroInteractor,
) : ViewModel() {

    private var heroes = mutableListOf<Hero>()
    private val _result = MutableLiveData<List<Hero>>()
    val result: LiveData<List<Hero>>
        get() = _result

    fun refreshListOfHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            heroInteractor.getHeroesList().also {
                heroes.clear()
                heroes.addAll(it)
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
    class HeroesListVMFactory @Inject constructor(
        private val heroInteractor: HeroInteractor,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            HeroListViewModel(heroInteractor) as T
    }
}