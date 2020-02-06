package com.jamadev.cityflagtest

import android.content.Intent
import android.os.Bundle
import com.jamadev.cityflagtest.applications.view.MainActivity
import com.jamadev.cityflagtest.base.BaseActivity

class SplashActivity :BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}