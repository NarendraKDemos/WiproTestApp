package com.techguys.wiprotestapp.di.components

import com.techguys.shaadiapptest.di.scopes.AppScope
import com.techguys.wiprotestapp.WiproTestApplication
import com.techguys.wiprotestapp.di.modules.AppModule
import com.techguys.wiprotestapp.di.modules.NetModule
import dagger.Component
import javax.inject.Singleton

@AppScope
@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface AppComponent {

    fun plusViewComponent(): ViewComponent

    fun inject(app: WiproTestApplication)
}