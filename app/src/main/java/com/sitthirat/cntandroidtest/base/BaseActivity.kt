package com.sitthirat.cntandroidtest.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

abstract class BaseActivity<B : ViewDataBinding, out VM : BaseViewModel>(clazz: KClass<VM>) : AppCompatActivity(),
    View.OnClickListener {

    protected lateinit var binding: B
    abstract var layoutResource: Int
    protected val mViewModel: VM by viewModel(clazz)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResource)
        initInstance()
        subscribeLiveData()
        if (savedInstanceState == null) {
            proceedFlow()
        }
    }

    open fun initInstance() {

    }

    open fun subscribeLiveData() {

    }

    open fun proceedFlow() {

    }

    override fun onClick(view: View) {
    }

    override fun onPause() {
        super.onPause()
    }
}