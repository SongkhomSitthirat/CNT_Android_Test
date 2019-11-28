package com.sitthirat.cntandroidtest.base

import com.sitthirat.cntandroidtest.model.Result

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

abstract class BaseCoroutinesUseCase<in P, R> {

    abstract suspend fun execute(parameters: P): Result<R>
}