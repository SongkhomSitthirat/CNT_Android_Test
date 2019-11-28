package com.sitthirat.cntandroidtest.view.main.forth

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.sitthirat.cntandroidtest.R
import com.sitthirat.cntandroidtest.base.BaseFragment
import com.sitthirat.cntandroidtest.databinding.FragmentForthBinding


/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class ForthFragment : BaseFragment<FragmentForthBinding, ForthFragmentViewModel>(ForthFragmentViewModel::class) {

    override var layoutResource: Int = R.layout.fragment_forth

    companion object {
        fun newInstance(): ForthFragment {
            return ForthFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }

    @SuppressLint("JavascriptInterface")
    override fun initInstance() {
        super.initInstance()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.addJavascriptInterface(AndroidToJs(mActivity), "test")
    }

    override fun proceedFlow() {
        super.proceedFlow()
        binding.webView.loadUrl("http://34.82.250.142/temp/testjs.html")
        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                binding.webView.loadUrl("javascript:window.test.toastFirstLine(document.getElementsByTagName('body')[0].innerText);")

            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.webView.saveState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let {
            binding.webView.restoreState(it)
        }
    }
}