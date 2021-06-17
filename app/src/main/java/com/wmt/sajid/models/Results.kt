package com.wmt.sajid.models

import com.google.gson.annotations.SerializedName
import com.wmt.sajid.models.*


data class Results (

    @SerializedName("gender") var gender : String,
    @SerializedName("name") var name : Name,
    @SerializedName("email") var email : String,
    @SerializedName("dob") var dob : Dob,
    @SerializedName("phone") var phone : String,
    @SerializedName("cell") var cell : String,
    @SerializedName("picture") var picture : Picture,
    @SerializedName("nat") var nat : String

)