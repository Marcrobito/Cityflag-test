package com.jamadev.cityflagtest.applications.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jamadev.cityflagtest.applications.model.AppDetail

import com.jamadev.cityflagtest.R
import kotlinx.android.synthetic.main.content_item.view.*

class AppListAdapter(private val items: List<AppDetail>, private val listener: OnItemClickListener)
    : RecyclerView.Adapter<AppListAdapter.VH>(), OnItemClickListener{

    override fun getItemCount() = items.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(parent, listener)

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    override fun onItemClick(position: Int) {
        listener.onItemClick(position)
    }

    class VH(parent: ViewGroup, private val listener: OnItemClickListener)  :
        RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.content_item, parent, false)), View.OnClickListener {

        fun bind(item:AppDetail) = with(itemView){
            this.setOnClickListener(this@VH)
            appTitleTextView.text = item.title
            descriptionTextView.text = item.summary
            Glide.with(context).load(item.images[item.images.count() - 1].url).into(appImageView)
        }

        override fun onClick(p0: View?) {
            listener.onItemClick(adapterPosition)
        }

    }




}

interface OnItemClickListener {
    fun onItemClick(position:Int)
}