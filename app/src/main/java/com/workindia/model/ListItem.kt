package com.workindia.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListItem {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("price")
    @Expose
    var price: String? = null

    @SerializedName("delivery")
    @Expose
    var delivery: String? = null
    @SerializedName("image_url")
    @Expose
    var imageurl: String? = null
}