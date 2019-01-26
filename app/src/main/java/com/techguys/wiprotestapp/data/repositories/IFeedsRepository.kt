package com.techguys.wiprotestapp.data.repositories

import com.techguys.wiprotestapp.data.remote.models.FeedsResponse
import io.reactivex.Single

interface IFeedsRepository {

    fun fetchFeeds(): Single<FeedsResponse>

}