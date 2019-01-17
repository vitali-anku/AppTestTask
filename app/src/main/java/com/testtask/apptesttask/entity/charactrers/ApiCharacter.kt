package com.testtask.apptesttask.entity.charactrers

import com.google.gson.annotations.SerializedName
import java.util.Date

data class ApiCharacter(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: Date,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("urls") val urls: List<Url>,
    @SerializedName("thumbnail") val thumbnail: Image,
    @SerializedName("comics") val comics: ComicList,
    @SerializedName("stories") val stories: StoryList,
    @SerializedName("events") val events: EventList,
    @SerializedName("series") val series: SeriesList
)