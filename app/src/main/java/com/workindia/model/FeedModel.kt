package com.workindia.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FeedModel {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var listData: ListData? = null
}