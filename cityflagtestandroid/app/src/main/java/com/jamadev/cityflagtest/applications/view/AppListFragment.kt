package com.jamadev.cityflagtest.applications.view


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.jamadev.cityflagtest.R
import com.jamadev.cityflagtest.applications.model.AppDetail
import com.jamadev.cityflagtest.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_app_list.view.*

/**
 * A simple [Fragment] subclass.
 */
class AppListFragment : BaseFragment(), OnItemClickListener {

    private lateinit var adapter : AppListAdapter
    private lateinit var manager:LinearLayoutManager

    private lateinit var recyclerView: RecyclerView

    private var listener: AppListFragmentsContract? = null

    override fun onAttach(context: Context) {
        if (context is AppListFragmentsContract)
            listener = context
        else
            throw Exception("You must implement AppListFragmentsContract")
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_app_list, container, false)
        manager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        v.recycler.adapter = adapter
        v.recycler.layoutManager = manager
        recyclerView = v.recycler
        return v
    }

    fun setData(appList: List<AppDetail>){
        adapter = AppListAdapter(appList, this)
    }

    override fun onItemClick(position: Int) {
        listener!!.appSelected(position)
    }


}
