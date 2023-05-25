package com.example.testappbnet.presentation.cardproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.testappbnet.R

class CardHeroFragment : Fragment() {

    private val image: ImageView = requireView().findViewById(R.id.ivProduct)
    private val genderIcon: ImageView = requireView().findViewById(R.id.ivGenderIcon)
    private val fullName: TextView = requireView().findViewById(R.id.tvFullName)
    private val status: TextView = requireView().findViewById(R.id.tvStatus)

    private val viewModel: CardHeroViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_card_hero, container, false)
    }
}