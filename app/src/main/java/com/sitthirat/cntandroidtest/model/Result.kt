package com.sitthirat.cntandroidtest.model

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

}