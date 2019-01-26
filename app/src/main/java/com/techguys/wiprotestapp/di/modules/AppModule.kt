package com.techguys.wiprotestapp.di.modules

import android.app.Application
import com.techguys.shaadiapptest.di.scopes.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: Application) {

    @Provides
    @AppScope
    fun provideAppContext(): Application {
        return app
    }





}