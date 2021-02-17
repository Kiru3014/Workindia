package com.workindia.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListData {
    @SerializedName("istiled")
    @Expose
    var istiled: Boolean? = null

    @SerializedName("items")
    @Expose
    var items: List<ListItem>? = null
}