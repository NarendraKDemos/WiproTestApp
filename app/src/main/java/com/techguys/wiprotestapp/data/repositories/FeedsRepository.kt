package com.techguys.wiprotestapp.data.repositories

import com.techguys.wiprotestapp.data.remote.WebService
import com.techguys.wiprotestapp.data.remote.models.FeedsResponse
import io.reactivex.Single
import javax.inject.Inject

class FeedsRepository @Inject constructor(private val webService: WebService): IFeedsRepository{
    override fun fetchFeeds(): Single<FeedsResponse> {
        return webService.getFeeds()
    }

}