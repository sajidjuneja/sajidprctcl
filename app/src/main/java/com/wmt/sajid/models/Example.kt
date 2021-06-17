package com.wmt.sajid.models

import com.google.gson.annotations.SerializedName

   
data class Example (

   @SerializedName("results") var results : List<Results>

)