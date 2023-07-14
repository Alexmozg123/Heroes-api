package com.example.testappbnet.di

import com.example.testappbnet.data.repository.RepositoryImpl
import com.example.testappbnet.domain.Repository
import dagger.Binds
import dagger.Module

@Module
interface BindsModule {

    @Suppress("FunctionName")
    @Binds
    fun bindsRepositoryImpl_to_Repository(
        repositoryImpl: RepositoryImpl
    ): Repository
}