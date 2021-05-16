package com.sude.nasaapi.model.spirit


import com.google.gson.annotations.SerializedName

data class spirit(
    @SerializedName("photos")
    val photos: List<Photo>
)