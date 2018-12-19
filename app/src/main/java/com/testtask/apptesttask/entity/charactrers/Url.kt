package com.testtask.apptesttask.entity.charactrers

import com.google.gson.annotations.SerializedName

data class Url(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
)