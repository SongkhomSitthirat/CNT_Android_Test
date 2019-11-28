package com.sitthirat.cntandroidtest.repository

import com.sitthirat.cntandroidtest.model.response.BaseResponseModel
import com.sitthirat.cntandroidtest.model.response.GetJsonDataModel
import retrofit2.Response

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

interface RemoteRepository {

    suspend fun getJsonDatas(): Response<BaseResponseModel<ArrayList<GetJsonDataModel>>>
}