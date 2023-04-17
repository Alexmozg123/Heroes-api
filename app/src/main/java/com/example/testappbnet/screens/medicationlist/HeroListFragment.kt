package com.example.testappbnet.screens.medicationlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.testappbnet.R
import com.example.testappbnet.models.Hero

class HeroListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel: HeroListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_medication_list, container, false)

        recyclerView = view.findViewById(R.id.rvMedications)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.result.observe(viewLifecycleOwner) {
            setAdapter(it)
        }
        viewModel.refreshListOfHeroes()
    }

    private fun setAdapter(listDrugs: List<Hero>) {
        recyclerView.adapter = HeroesAdapter(listDrugs)
    }
}