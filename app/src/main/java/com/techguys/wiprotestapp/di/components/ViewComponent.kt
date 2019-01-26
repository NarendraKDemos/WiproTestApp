package com.techguys.wiprotestapp.di.components

import com.techguys.wiprotestapp.di.modules.ViewModelsModule
import com.techguys.wiprotestapp.di.scopes.ViewScope
import com.techguys.wiprotestapp.ui.feeds.FeedsActivity
import dagger.Subcomponent

@ViewScope
@Subcomponent(modules = [ViewModelsModule::class])
interface ViewComponent {

    fun inject(feedsActivity: FeedsActivity)
}