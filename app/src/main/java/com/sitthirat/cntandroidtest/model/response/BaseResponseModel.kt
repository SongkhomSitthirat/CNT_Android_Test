package com.sitthirat.cntandroidtest.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

open class BaseResponseModel<T> {

    @SerializedName("status")
    val status: Int? = null
    @SerializedName("info")
    val info: String? = null
    @SerializedName("data")
    val data: T? = null
}