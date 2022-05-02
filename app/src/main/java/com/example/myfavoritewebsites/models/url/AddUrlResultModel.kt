package com.example.myfavoritewebsites.models.url

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class AddUrlResultModel(
    var self: String = "",
    var short: String = ""
) : Parcelable
