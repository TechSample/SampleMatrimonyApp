package com.app.matrimonyapp.base

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.matrimonyapp.utils.LoadingDialog

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity(), UICallbacks<V> {

    protected lateinit var mBinding: T
    protected lateinit var mViewModel: V
    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this@BaseActivity, getLayoutId())
        mViewModel = ViewModelProvider(this@BaseActivity).get(getViewModel())
        mViewModel.setNavigator(getNavigator())
        mContext = this@BaseActivity
        createDialog()
        onBinding()
    }

    private fun createDialog() {
        val dialog = LoadingDialog(this@BaseActivity)
        mViewModel.getVisibility().observe(this@BaseActivity, Observer { show ->
            dialog.run {
                if (show) show() else hide()
            }
        })
        mViewModel.getMessage().observe(this@BaseActivity, Observer {
            dialog.setMessage(it)
        })

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}
