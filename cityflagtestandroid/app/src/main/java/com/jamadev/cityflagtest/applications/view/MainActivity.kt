package com.jamadev.cityflagtest.applications.view

import android.os.Bundle
import androidx.lifecycle.Observer
import com.jamadev.cityflagtest.R
import com.jamadev.cityflagtest.applications.viewmodel.AppViewModel
import com.jamadev.cityflagtest.base.BaseActivity
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(),
    AppListFragmentsContract{

    private val viewModel:AppViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getFragment().observe(this, Observer {
            supportFragmentManager.beginTransaction().replace(
                R.id.container, it
            ).commit()
        })
    }

    override fun appSelected(position: Int) {
        viewModel.appSelected(position)
    }

    override fun onBackPressed() {
        viewModel.backPressed()
    }


}
