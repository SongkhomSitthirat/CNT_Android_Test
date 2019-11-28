package com.sitthirat.cntandroidtest.view.main.third

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sitthirat.cntandroidtest.R
import com.sitthirat.cntandroidtest.Singleton
import com.sitthirat.cntandroidtest.base.BaseFragment
import com.sitthirat.cntandroidtest.databinding.FragmentThirdBinding

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class ThirdFragment : BaseFragment<FragmentThirdBinding, ThirdFragmentViewModel>(ThirdFragmentViewModel::class) {

    override var layoutResource: Int = R.layout.fragment_third

    companion object {
        fun newInstance(): ThirdFragment {
            return ThirdFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }

    override fun initInstance() {
        super.initInstance()
        binding.btnSave.setOnClickListener(this)
        binding.btnRead.setOnClickListener(this)
        binding.btnSingleton.setOnClickListener(this)
        binding.btnStartThread.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when (view?.id) {
            R.id.btnSave -> {
                mViewModel.saveDataToSharedPreferences("Zhangsan")
            }
            R.id.btnRead -> {
                binding.tvName.text = "${mActivity.resources.getString(R.string.label_name)} ${mViewModel.readDataFromSharedPreferences()}"
            }
            R.id.btnSingleton -> {
                Singleton.say(mActivity)
            }
            R.id.btnStartThread -> {
                mHandler.postDelayed({
                    Toast.makeText(mActivity, "Thread is Running", Toast.LENGTH_SHORT).show()
                }, 2000)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Name", binding.tvName.text.toString())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let {
            binding.tvName.text = it.getString("Name")
                    ?: mActivity.resources.getString(R.string.label_name)
        }
    }
}