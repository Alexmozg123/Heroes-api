package com.example.testappbnet.presentation.medicationlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testappbnet.R
import com.example.testappbnet.domain.models.Hero

class HeroListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel: HeroListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hero_list, container, false)
        recyclerView = view.findViewById(R.id.rvMedications)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeViewModel()
        viewModel.refreshListOfHeroes()
    }

    override fun onPause() {
        super.onPause()
        recyclerView.layoutManager?.onSaveInstanceState()?.let {
            viewModel.saveRecyclerViewState(it)
        }
    }

    private fun observeViewModel() {
        viewModel.result.observe(viewLifecycleOwner) {
            setAdapter(it)
            setRecyclerViewState()
        }
        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAdapter(listOfHeroes: List<Hero>) {
        val adapter = HeroesAdapter(listOfHeroes) { hero->
            navigateToCardHeroFragment(hero)
        }
        adapter.submitList(listOfHeroes)
        recyclerView.adapter = adapter
    }

    private fun setRecyclerViewState() {
        if (viewModel.stateInitialized()) {
            recyclerView.layoutManager?.onRestoreInstanceState(
                viewModel.restoreRecyclerViewState()
            )
        }
    }

    private fun navigateToCardHeroFragment(hero: Hero) {
        val action = HeroListFragmentDirections
            .actionMedicationListFragmentToCardProductFragment(hero)
        requireView().findNavController().navigate(action)
    }
}