package com.jamadev.cityflagtest.base

import android.annotation.SuppressLint
import android.app.Activity
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {

    open fun hideKeyboard(activity: Activity) {
        val imm = activity.getSystemService(
            Activity.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        var view = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed()
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {

    }
}