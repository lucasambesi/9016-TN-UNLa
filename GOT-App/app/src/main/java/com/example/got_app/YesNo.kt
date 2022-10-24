package com.example.got_app

import com.google.gson.annotations.SerializedName

data class YesNo(
    @SerializedName("answer")
    var answer: String?,

    @SerializedName("forced")
    var forced: String?,

    @SerializedName("image")
    var image: String?
)
