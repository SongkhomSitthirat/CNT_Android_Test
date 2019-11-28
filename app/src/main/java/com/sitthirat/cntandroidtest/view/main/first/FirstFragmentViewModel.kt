package com.sitthirat.cntandroidtest.view.main.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sitthirat.cntandroidtest.base.BaseViewModel
import com.sitthirat.cntandroidtest.model.Result
import com.sitthirat.cntandroidtest.model.response.GetJsonDataModel
import com.sitthirat.cntandroidtest.usecase.GetJsonDatasUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class FirstFragmentViewModel(
        private val getJsonDatasUseCase: GetJsonDatasUseCase
) : BaseViewModel() {

    val jsonDataListLiveData: MutableLiveData<ArrayList<GetJsonDataModel>> = MutableLiveData()

    fun callServiceGetJsonDatas() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when (val result = getJsonDatasUseCase.execute(Unit)) {
                    is Result.Success -> {
                        jsonDataListLiveData.postValue(result.data)
                    }
                    is Result.Error -> {

                    }

                }
            }
        }
    }
}