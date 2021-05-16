package com.sude.nasaapi.model.opportunity


import com.google.gson.annotations.SerializedName

data class Opportunity(
    @SerializedName("photos")
    val photos: List<Photo>
)