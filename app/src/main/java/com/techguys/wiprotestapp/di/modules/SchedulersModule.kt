package com.techguys.wiprotestapp.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module
class SchedulersModule {

    @Provides
    @Named("MainScheduler")
    fun provideMainThreadSchedulter(): Scheduler {
        return AndroidSchedulers.mainThread()
    }


    @Provides
    @Named("IOScheduler")
    fun provideIOScheduler(): Scheduler {
        return Schedulers.newThread()
    }

    @Provides
    @Named("ComputationScheduler")
    fun provideComputationScheduler(): Scheduler {
        return Schedulers.computation()
    }
}