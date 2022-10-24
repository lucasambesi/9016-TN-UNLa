package com.example.got_app

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("url")
    var id: String?,

    @SerializedName("name")
    var name: String?,

    @SerializedName("gender")
    var gender: String?,

    @SerializedName("born")
    var born: String?,

    @SerializedName("died")
    var died: String?
)