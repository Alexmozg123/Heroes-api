package com.example.testappbnet.di

import com.example.testappbnet.ui.medicationlist.HeroListFragment
import dagger.Component

@Component(modules = [NetworkModule::class, BindsModule::class])
interface AppComponent {
    fun inject(fragment: HeroListFragment)
}