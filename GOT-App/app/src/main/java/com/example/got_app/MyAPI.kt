package com.example.got_app

import retrofit2.Call
import retrofit2.http.GET

interface MyAPI {
    @GET("characters/")
    fun getPost() : Call<List<Post>>
}