package com.techguys.wiprotestapp.di.modules

import com.techguys.wiprotestapp.data.remote.WebService
import com.techguys.wiprotestapp.data.repositories.FeedsRepository
import com.techguys.wiprotestapp.data.repositories.IFeedsRepository
import com.techguys.wiprotestapp.di.scopes.ViewScope
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    @ViewScope
    fun provideFeedsRepository(webService: WebService): IFeedsRepository {
        return FeedsRepository(webService)
    }

}