package com.example.got_app
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object YesNoClient {
    private val baseUrl = "https://yesno.wtf/"

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}