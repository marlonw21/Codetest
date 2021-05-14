package com.mw21.codetest.presentation.di.home

import com.mw21.codetest.presentation.home.HomeActivity
import dagger.Subcomponent

@HomeScope
@Subcomponent(modules = [
    HomeModule::class
])
interface HomeSubComponent {
    fun inject(homeActivity: HomeActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): HomeSubComponent
    }
}