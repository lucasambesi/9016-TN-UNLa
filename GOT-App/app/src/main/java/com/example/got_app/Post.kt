package com.example.got_app

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class Post(
    var name: String,
    var gender : String,
    var culture: String
)
