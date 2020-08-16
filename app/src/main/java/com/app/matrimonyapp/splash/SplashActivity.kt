package com.app.matrimonyapp.splash

import android.content.Intent
import android.os.Handler
import android.view.Window
import com.app.matrimonyapp.R
import com.app.matrimonyapp.base.BaseActivity
import com.app.matrimonyapp.base.BaseNavigator
import com.app.matrimonyapp.databinding.ActivitySplashBinding
import com.app.matrimonyapp.user_list.UserListActivity
import com.app.matrimonyapp.utils.showMessage

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashNavigator {

    private val handler = Handler()

    override fun getLayoutId(): Int {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        return R.layout.activity_splash
    }

    override fun getViewModel(): Class<SplashViewModel> = SplashViewModel::class.java
    override fun getNavigator(): BaseNavigator = this@SplashActivity
    override fun onInternetError() {}
    override fun onError(message: String) = showMessage(message)

    override fun onBinding() {
        handler.postDelayed({
            startActivity(Intent(this@SplashActivity, UserListActivity::class.java))
            finish()
        }, 2000)
    }

}
