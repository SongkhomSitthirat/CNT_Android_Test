package com.sitthirat.cntandroidtest.view.main

import android.os.Bundle
import com.sitthirat.cntandroidtest.R
import com.sitthirat.cntandroidtest.base.BaseFragment
import com.sitthirat.cntandroidtest.databinding.FragmentMainBinding
import com.sitthirat.cntandroidtest.extension.replaceFragment
import com.sitthirat.cntandroidtest.view.main.first.FirstFragment
import com.sitthirat.cntandroidtest.view.main.forth.ForthFragment
import com.sitthirat.cntandroidtest.view.main.second.SecondFragment
import com.sitthirat.cntandroidtest.view.main.third.ThirdFragment

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>(MainFragmentViewModel::class) {

    override var layoutResource: Int = R.layout.fragment_main

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }

    override fun initInstance() {
        super.initInstance()
        initBottomNavigation()
    }

    override fun proceedFlow() {
        super.proceedFlow()
        binding.bottomNavigation.selectedItemId = R.id.tabOne
    }

    private fun initBottomNavigation() {
        binding.bottomNavigation.itemIconTintList = null
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            binding.tvTitle.text = it.title
            when (it.itemId) {
                R.id.tabOne -> {
                    replaceFragment(R.id.contentContainer, FirstFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tabTwo -> {
                    replaceFragment(R.id.contentContainer, SecondFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tabThree -> {
                    replaceFragment(R.id.contentContainer, ThirdFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tabFour -> {
                    replaceFragment(R.id.contentContainer, ForthFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("TabTitle", binding.tvTitle.text.toString())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let {
            binding.tvTitle.text = it.getString("TabTitle", mActivity.resources.getString(R.string.tab_one))
        }
    }
}