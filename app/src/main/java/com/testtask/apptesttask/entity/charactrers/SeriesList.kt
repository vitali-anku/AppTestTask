package com.testtask.apptesttask.entity.charactrers

import com.google.gson.annotations.SerializedName

data class SeriesList(
    @SerializedName("available") val available: Int,
    @SerializedName("returned") val returned: Int,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("items") val items: List<SeriesSummary>
)