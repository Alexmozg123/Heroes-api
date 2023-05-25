package com.example.testappbnet.presentation.cardproduct

import androidx.lifecycle.*
import com.example.testappbnet.domain.Hero
import com.example.testappbnet.domain.Repository
import kotlinx.coroutines.launch

class CardHeroViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _result = MutableLiveData<Hero>()
    val result: LiveData<Hero>
        get() = _result

    fun getHero(heroId: Int) {
        viewModelScope.launch {
            _result.postValue(repository.getHeroById(heroId))
        }
    }

    @Suppress("UNCHECKED_CAST")
    class CardHeroVMFactory(
        private val repository: Repository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            CardHeroViewModel(repository) as T
    }
}
