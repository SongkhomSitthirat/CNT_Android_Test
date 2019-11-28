package com.sitthirat.cntandroidtest.view.main.second

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.view.View
import android.widget.Toast
import com.sitthirat.cntandroidtest.R
import com.sitthirat.cntandroidtest.base.BaseFragment
import com.sitthirat.cntandroidtest.databinding.FragmentSecondBinding
import com.sitthirat.cntandroidtest.service.BindService
import com.sitthirat.cntandroidtest.service.TestService
import com.sitthirat.cntandroidtest.view.SecondActivity

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class SecondFragment : BaseFragment<FragmentSecondBinding, SecondFragmentViewModel>(SecondFragmentViewModel::class) {

    override var layoutResource: Int = R.layout.fragment_second
    private lateinit var bindService: BindService

    companion object {
        const val REQUEST_CODE = 8

        fun newInstance(): SecondFragment {
            return SecondFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }

    override fun initInstance() {
        super.initInstance()
        binding.btnStart.setOnClickListener(this)
        binding.btnStartService.setOnClickListener(this)
        binding.btnBindService.setOnClickListener(this)
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            if (service is BindService.LocalBinder) {
                this@SecondFragment.bindService = service.getService()
                this@SecondFragment.bindService.toastBindServiceSuccess()
                unbindService()
            }

        }
    }

    fun unbindService() {
        mActivity.unbindService(serviceConnection)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when (view?.id) {
            R.id.btnStart -> {
                val intent = Intent(mActivity, SecondActivity::class.java)
                intent.putExtra("data", "I am jack")
                startActivityForResult(intent, REQUEST_CODE)
            }
            R.id.btnStartService -> {
                val intent = Intent(mActivity, TestService::class.java)
                mActivity.startService(intent)
            }
            R.id.btnBindService -> {
                val intent = Intent(mActivity, BindService::class.java)
                mActivity.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE -> {
                data?.let {
                    val string = it.getStringExtra("data")
                    Toast.makeText(mActivity, string, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}