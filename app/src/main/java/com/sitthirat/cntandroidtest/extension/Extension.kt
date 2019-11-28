package com.sitthirat.cntandroidtest.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sitthirat.cntandroidtest.model.response.BaseResponseModel
import retrofit2.Response

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

fun <T : BaseResponseModel<*>>Response<T>.isSuccess():Boolean {
    return this.isSuccessful && this.body() != null && this.body()?.status == 1 && this.body()?.info == "success"
}

fun AppCompatActivity.replaceFragment(containerId: Int, fragment: Fragment) {
    this.supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
}

fun AppCompatActivity.replaceFragment(containerId: Int, fragment: Fragment, tag: String) {
    this.supportFragmentManager.beginTransaction()
            .replace(containerId, fragment, tag)
            .commit()
}

fun Fragment.replaceFragment(containerId: Int, fragment: Fragment) {
    this.childFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
}

fun Fragment.replaceFragment(containerId: Int, fragment: Fragment, tag: String) {
    this.childFragmentManager.beginTransaction()
            .replace(containerId, fragment, tag)
            .commit()
}

inline fun <reified T> Gson.fromJson(json: String) =
        this.fromJson<T>(json, object : TypeToken<T>() {}.type)