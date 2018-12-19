package com.testtask.apptesttask.entity.charactrers

import com.google.gson.annotations.SerializedName

data class StorySummary(
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String
)