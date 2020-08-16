package com.app.matrimonyapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.app.matrimonyapp.base.MatrimonyApplication


fun AppCompatActivity.showMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showMessage(message: String) {
    Toast.makeText(this.activity, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.hideKeyboard() {
    val view = this.currentFocus
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    view?.let {
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun isNetworkAvailable(): Boolean {
    val cm = MatrimonyApplication.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    cm.activeNetworkInfo?.run {
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork.isConnected
    }
    return false
}

@BindingAdapter("showHide")
fun showHide(view: View, showHide: Boolean) {
    view.visibility = if (showHide) View.VISIBLE else View.GONE
}