package com.example.testappbnet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.testappbnet.data.repository.Repository
import com.example.testappbnet.screens.medicationlist.HeroListViewModel

class MainActivity : AppCompatActivity() {

    private val repository = Repository()
    private lateinit var medicationListViewModel: HeroListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        medicationListViewModel = ViewModelProvider(this,
            HeroListViewModel.MedicationListVMFactory(repository)
        )[HeroListViewModel::class.java]

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        findViewById<Toolbar>(R.id.tbMain)
            .setupWithNavController(navController, appBarConfiguration)
    }
}