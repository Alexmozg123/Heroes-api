package com.example.testappbnet.ui.medicationlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testappbnet.R
import com.example.testappbnet.data.api.RetrofitInstance
import com.example.testappbnet.data.repository.RepositoryImpl
import com.example.testappbnet.domain.HeroInteractor
import com.example.testappbnet.domain.models.Hero

class HeroListFragment : Fragment() {

    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private val adapter = HeroesAdapter { hero -> navigateToCardHeroFragment(hero) }

    private val viewModel: HeroListViewModel by viewModels{
        HeroListViewModel.HeroesListVMFactory(
            HeroInteractor(RepositoryImpl(RetrofitInstance.api))
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hero_list, container, false)
        recyclerView = view.findViewById(R.id.rvMedications)
        searchView = view.findViewById(R.id.searchView)
        searchView.clearFocus()
        searchView.setOnQueryTextListener(createSearchListener())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.adapter = adapter

        viewModel.result.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.refreshListOfHeroes()
    }

    private fun createSearchListener() = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean = false

        override fun onQueryTextChange(newText: String): Boolean {
            viewModel.onTextChanged(newText)
            return true
        }
    }

    private fun navigateToCardHeroFragment(hero: Hero) {
        val action = HeroListFragmentDirections
            .actionMedicationListFragmentToCardProductFragment(hero)
        requireView().findNavController().navigate(action)
    }
}