package com.techguys.wiprotestapp.di.modules

import com.techguys.wiprotestapp.data.remote.WebService
import com.techguys.wiprotestapp.data.repositories.FeedsRepository
import com.techguys.wiprotestapp.data.repositories.IFeedsRepository
import com.techguys.wiprotestapp.di.scopes.ViewScope
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import javax.inject.Named

@Module
class RepositoryModule {

    @Provides
    @ViewScope
    fun provideFeedsRepository(
        webService: WebService,
        @Named("IOScheduler") subscribeOnScheduler: Scheduler,
        @Named("MainScheduler") observeOnScheduler: Scheduler
    ): IFeedsRepository {
        return FeedsRepository(webService, subscribeOnScheduler, observeOnScheduler)
    }

}