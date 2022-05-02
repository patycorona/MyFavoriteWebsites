package com.example.myfavoritewebsites.models.url

import com.google.gson.annotations.SerializedName

data class AddUrlResult(
    @SerializedName("self") val self: String = "",
    @SerializedName("short") val short: String = ""
)
