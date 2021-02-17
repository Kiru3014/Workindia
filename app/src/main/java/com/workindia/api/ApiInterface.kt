package com.workindia.api

import com.workindia.model.FeedModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface ApiInterface {
    @GET("{path}")
    @Headers("Accept: application/json")
    fun getFeedData(@Path("path") path: String): Call<FeedModel>

}


