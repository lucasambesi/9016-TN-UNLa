package com.example.got_app

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface MyAPI {
    @GET
    suspend fun getCharacters(@Url url:String) : Response<List<Character>>
    @GET
    suspend fun getCharacter(@Url url:String) : Response<Character>
    @GET
    suspend fun getHouse(@Url url:String) : Response<House>
}