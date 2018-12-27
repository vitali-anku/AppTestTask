package com.testtask.apptesttask.model.data.server

import com.testtask.apptesttask.entity.charactrers.CharacterDataWrapper
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MarvelService {

    @GET("/v1/public/characters")
    @Headers("Content-Type: application/json")
    fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") publicKey: String,
        @Query("hash") hash: String
    ): Single<CharacterDataWrapper>
}