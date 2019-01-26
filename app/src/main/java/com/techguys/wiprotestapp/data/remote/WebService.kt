package com.techguys.wiprotestapp.data.remote

import com.techguys.wiprotestapp.data.remote.models.FeedsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface WebService{

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getFeeds(): Single<FeedsResponse>
}
