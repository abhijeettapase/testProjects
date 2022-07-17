package com.example.mvvmbasedonmicroloan.RetrofitServices

import com.google.gson.annotations.SerializedName

data class APIResponseModel(

    @SerializedName("id")
    var id : String = "",

    @SerializedName("description")
    var description : String = "",

    @SerializedName("category")
    var category : String = ""

)
