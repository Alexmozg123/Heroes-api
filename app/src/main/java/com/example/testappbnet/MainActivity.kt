package com.example.testappbnet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.testappbnet.data.repository.RepositoryImpl
import com.example.testappbnet.presentation.medicationlist.HeroListViewModel

class MainActivity : AppCompatActivity() {

    private val repository = RepositoryImpl()
    private lateinit var heroesListViewModel: HeroListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModels()
        initNavigation()
    }

    private fun initViewModels() {
        heroesListViewModel = ViewModelProvider(
            this,
            HeroListViewModel.MedicationListVMFactory(repository)
        )[HeroListViewModel::class.java]
    }

    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        findViewById<Toolbar>(R.id.tbMain)
            .setupWithNavController(navController, appBarConfiguration)
    }
}