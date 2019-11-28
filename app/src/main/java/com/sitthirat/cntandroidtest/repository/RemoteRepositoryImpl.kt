package com.sitthirat.cntandroidtest.repository

import com.sitthirat.cntandroidtest.model.response.BaseResponseModel
import com.sitthirat.cntandroidtest.model.response.GetJsonDataModel
import com.sitthirat.cntandroidtest.network.EndpointInterface
import retrofit2.Response

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class RemoteRepositoryImpl(private val mService: EndpointInterface) : RemoteRepository {

    private var jsonDataResponse: Response<BaseResponseModel<ArrayList<GetJsonDataModel>>>? = null

    override suspend fun getJsonDatas(): Response<BaseResponseModel<ArrayList<GetJsonDataModel>>> {
        if (jsonDataResponse == null) {
            jsonDataResponse = mService.getJsonDatas()
        }
        return jsonDataResponse!!
    }
}