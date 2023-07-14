package com.example.testappbnet.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.testappbnet.R
import com.example.testappbnet.di.AppComponent
import com.example.testappbnet.di.DaggerAppComponent

class MainActivity : AppCompatActivity() {

    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = DaggerAppComponent.create()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.tbMain))

        initNavigation()
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

val Context.appComponent: AppComponent
    get() = when(this) {
        is MainActivity -> appComponent
        else -> this.applicationContext.appComponent
    }
