package com.sitthirat.cntandroidtest.view.main.first

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.sitthirat.cntandroidtest.R
import com.sitthirat.cntandroidtest.base.BaseFragment
import com.sitthirat.cntandroidtest.databinding.FragmentFirstBinding
import com.sitthirat.cntandroidtest.extension.fromJson
import com.sitthirat.cntandroidtest.model.response.GetJsonDataModel
import com.sitthirat.cntandroidtest.view.main.first.adapter.FirstRecyclerAdapter

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class FirstFragment : BaseFragment<FragmentFirstBinding, FirstFragmentViewModel>(FirstFragmentViewModel::class) {

    override var layoutResource: Int = R.layout.fragment_first
    private lateinit var recyclerAdapter: FirstRecyclerAdapter
    private var jsonDataList: ArrayList<GetJsonDataModel>? = null

    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }

    override fun initInstance() {
        super.initInstance()
        initRecyclerFirst()
    }

    private fun initRecyclerFirst() {
        recyclerAdapter = FirstRecyclerAdapter()
        binding.recyclerView.apply {
            this.adapter = recyclerAdapter
            this.layoutManager = LinearLayoutManager(mActivity, RecyclerView.VERTICAL, false)
        }
    }

    override fun subscribeLiveData() {
        super.subscribeLiveData()
        mViewModel.jsonDataListLiveData.observe(this, Observer {
            recyclerAdapter.jsonDataList = it
            recyclerAdapter.notifyDataSetChanged()
        })
    }

    override fun proceedFlow() {
        super.proceedFlow()
        if (jsonDataList == null) {
            mViewModel.callServiceGetJsonDatas()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (::recyclerAdapter.isInitialized) {
            outState.putString("dataList", Gson().toJson(recyclerAdapter.jsonDataList))
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            val jsonDataListString: String? = savedInstanceState.getString("dataList")
            if (jsonDataListString.isNullOrBlank()) {
                mViewModel.callServiceGetJsonDatas()
            } else {
                jsonDataList = Gson().fromJson(jsonDataListString)
                recyclerAdapter.jsonDataList = jsonDataList
                recyclerAdapter.notifyDataSetChanged()
            }
        }
    }
}