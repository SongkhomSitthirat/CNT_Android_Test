package com.sitthirat.cntandroidtest.network

import com.sitthirat.cntandroidtest.model.response.BaseResponseModel
import com.sitthirat.cntandroidtest.model.response.GetJsonDataModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

interface EndpointInterface {

    @GET("jsondatas.html")
    suspend fun getJsonDatas(): Response<BaseResponseModel<ArrayList<GetJsonDataModel>>>
}