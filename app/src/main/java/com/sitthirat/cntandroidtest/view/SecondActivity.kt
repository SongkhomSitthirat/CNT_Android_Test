package com.sitthirat.cntandroidtest.view

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.sitthirat.cntandroidtest.R
import com.sitthirat.cntandroidtest.base.BaseActivity
import com.sitthirat.cntandroidtest.databinding.ActivityMainBinding
import com.sitthirat.cntandroidtest.databinding.ActivitySecondBinding
import com.sitthirat.cntandroidtest.extension.replaceFragment
import com.sitthirat.cntandroidtest.view.main.MainFragment

class SecondActivity : BaseActivity<ActivitySecondBinding, SecondActivityViewModel>(SecondActivityViewModel::class) {

    override var layoutResource: Int = R.layout.activity_second

    override fun proceedFlow() {
        super.proceedFlow()
        val string = intent.extras?.getString("data") ?: ""
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        intent.putExtra("data","I am is returned form B")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
