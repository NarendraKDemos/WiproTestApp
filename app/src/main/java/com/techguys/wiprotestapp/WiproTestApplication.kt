package com.techguys.wiprotestapp

import android.app.Application
import com.techguys.wiprotestapp.data.remote.BASE_URL
import com.techguys.wiprotestapp.di.components.AppComponent
import com.techguys.wiprotestapp.di.components.DaggerAppComponent
import com.techguys.wiprotestapp.di.modules.AppModule
import com.techguys.wiprotestapp.di.modules.NetModule

class WiproTestApplication: Application(){

    private lateinit var appComp: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComp = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule(BASE_URL))
            .build()
        appComp.inject(this)
    }

    fun getAppComp(): AppComponent = appComp
}