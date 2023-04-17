package com.example.testappbnet.screens.cardproduct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testappbnet.data.repository.Repository

class CardHeroViewModel(
    private val repository: Repository
) : ViewModel() {


    @Suppress("UNCHECKED_CAST")
    class CardHeroVMFactory(
        private val repository: Repository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            CardHeroViewModel(repository) as T
    }
}
