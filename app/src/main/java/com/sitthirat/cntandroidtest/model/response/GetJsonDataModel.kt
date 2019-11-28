package com.sitthirat.cntandroidtest.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

data class GetJsonDataModel(
        @SerializedName("Id")
        val id: Int? = null,
        @SerializedName("Name")
        val name: String? = "",
        @SerializedName("Author")
        val author: String? = "",
        @SerializedName("Img")
        val img: String? = "",
        @SerializedName("Desc")
        val desc: String? = "",
        @SerializedName("CName")
        val cName: String? = "",
        @SerializedName("Score")
        val score: Float? = null
)