package com.example.lovecalculator.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculatePercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "e4770650edmsh9eea983838b74e5p1e48ccjsnc9fd99ac5795",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}