package com.sitthirat.cntandroidtest.view

import android.os.Bundle
import com.sitthirat.cntandroidtest.R
import com.sitthirat.cntandroidtest.base.BaseActivity
import com.sitthirat.cntandroidtest.databinding.ActivityMainBinding
import com.sitthirat.cntandroidtest.extension.replaceFragment
import com.sitthirat.cntandroidtest.view.main.MainFragment

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(MainActivityViewModel::class) {

    override var layoutResource: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            replaceFragment(R.id.contentContainer, MainFragment.newInstance())
        }
    }
}
