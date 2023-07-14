package com.example.testappbnet.ui.cardproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.testappbnet.R
import com.squareup.picasso.Picasso

class CardHeroFragment : Fragment() {

    private lateinit var image: ImageView
    private lateinit var genderIcon: ImageView
    private lateinit var fullName: TextView
    private lateinit var status: TextView

    private val heroArgs: CardHeroFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card_hero, container, false)
        image = view.findViewById(R.id.ivHero)
        genderIcon = view.findViewById(R.id.ivGenderIcon)
        fullName = view.findViewById(R.id.tvFullName)
        status = view.findViewById(R.id.tvStatus)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fillHeroCard()
    }

    private fun fillHeroCard() {
        fullName.text = heroArgs.hero.name
        status.text = heroArgs.hero.status
        Picasso.get().load(heroArgs.hero.image).into(image)
        when (heroArgs.hero.gender) {
            getString(R.string.male) ->
                genderIcon.setImageResource(R.drawable.baseline_male_24)
            getString(R.string.female) ->
                genderIcon.setImageResource(R.drawable.baseline_female_24)
            else ->
                genderIcon.setImageResource(R.drawable.baseline_question_mark_24)
        }
    }
}