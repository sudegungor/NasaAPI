package com.sude.nasaapi.model.curiosity


import com.google.gson.annotations.SerializedName

data class Curiosity(
    @SerializedName("photos")
    val photos: List<Photo>
)