package com.sitthirat.cntandroidtest.view.main.third

import com.sitthirat.cntandroidtest.base.BaseViewModel
import com.sitthirat.cntandroidtest.util.SharedPref

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class ThirdFragmentViewModel(private val sharedPref: SharedPref) : BaseViewModel() {

    fun saveDataToSharedPreferences(name: String) {
        sharedPref.name = name
    }

    fun readDataFromSharedPreferences(): String = sharedPref.name
}