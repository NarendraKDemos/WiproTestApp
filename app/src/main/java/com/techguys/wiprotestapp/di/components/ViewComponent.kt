package com.techguys.wiprotestapp.di.components

import com.techguys.wiprotestapp.di.modules.RepositoryModule
import com.techguys.wiprotestapp.di.scopes.ViewScope
import com.techguys.wiprotestapp.ui.feeds.FeedsActivity
import dagger.Subcomponent

@ViewScope
@Subcomponent(modules = [RepositoryModule::class])
interface ViewComponent {

    fun inject(feedsActivity: FeedsActivity)
}