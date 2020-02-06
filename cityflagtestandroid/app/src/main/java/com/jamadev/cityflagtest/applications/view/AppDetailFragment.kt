package com.jamadev.cityflagtest.applications.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.jamadev.cityflagtest.R
import com.jamadev.cityflagtest.applications.model.AppDetail
import com.jamadev.cityflagtest.base.BaseFragment
import kotlinx.android.synthetic.main.content_item.view.*
import kotlinx.android.synthetic.main.fragment_app_detail.*
import kotlinx.android.synthetic.main.fragment_app_detail.view.*
import kotlinx.android.synthetic.main.fragment_app_list.*

/**
 * A simple [Fragment] subclass.
 */
class AppDetailFragment : BaseFragment() {

    private lateinit var appDetail: AppDetail

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_app_detail, container, false)
        Glide.with(this).load(appDetail.images[appDetail.images.count() - 1].url).into(v.imageView)
        v.textView.text = appDetail.title
        v.appDesTextView.text = appDetail.summary
        return v
    }

    fun setAppData(appDetail: AppDetail){
        this.appDetail = appDetail
    }


}
