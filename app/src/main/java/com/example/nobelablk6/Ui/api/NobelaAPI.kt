package com.example.nobelablk6.Ui.api

import com.example.nobelablk6.Ui.models.NobelaResponseItem
import com.example.nobelablk6.Ui.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NobelaAPI {

    @GET("https://aanobelax-55fdf2fca4c8.herokuapp.com/")
    suspend fun getNobela(
        @Query("country")
        countryCode: String = "ph",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NobelaResponseItem>

    @GET("https://aanobelax-55fdf2fca4c8.herokuapp.com/")
    suspend fun searchForNobela(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NobelaResponseItem>
}