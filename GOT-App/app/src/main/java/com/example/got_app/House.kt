package com.example.got_app

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class House(
    @SerializedName("name")
    var name: String?,

    @SerializedName("swornMembers")
    var characters: ArrayList<String>?,
)
