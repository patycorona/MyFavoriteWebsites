package com.example.myfavoritewebsites.mapping

import com.example.myfavoritewebsites.models.url.AddUrlResponse
import com.example.myfavoritewebsites.models.url.AddUrlResponseModel

internal fun AddUrlResponse.toModel() =
    AddUrlResponseModel(alias = alias, links = links)
