package com.sitthirat.cntandroidtest.usecase

import com.sitthirat.cntandroidtest.base.BaseCoroutinesUseCase
import com.sitthirat.cntandroidtest.extension.isSuccess
import com.sitthirat.cntandroidtest.model.Result
import com.sitthirat.cntandroidtest.model.response.GetJsonDataModel
import com.sitthirat.cntandroidtest.repository.RemoteRepositoryImpl
import retrofit2.HttpException

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class GetJsonDatasUseCase(private val remoteRepository: RemoteRepositoryImpl) : BaseCoroutinesUseCase<Unit, ArrayList<GetJsonDataModel>>() {
    override suspend fun execute(parameters: Unit): Result<ArrayList<GetJsonDataModel>> {
        return try {
            val response = remoteRepository.getJsonDatas()
            if (response.isSuccess()) {
                Result.Success(response.body()!!.data!!)
            } else {
                Result.Error(HttpException(response))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}