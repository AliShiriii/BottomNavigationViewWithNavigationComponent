package com.example.testapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapplication.Model.GetContent
import com.example.testapplication.R
import kotlinx.android.synthetic.main.row_view.view.*

class RequestAdapter() : PagingDataAdapter<GetContent, RequestAdapter.MyViewHolder>(
   PERSON_COMPARATOR ) {

//
//    private var items = emptyList<RequestBody>()
//
//    fun setData(item: List<RequestBody>?) {
//
//        if (item != null) {
//            items = item
//        }
//
//        notifyDataSetChanged()
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestAdapter.MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_view, parent, false)

        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: RequestAdapter.MyViewHolder, position: Int) {

        val itemRequest = getItem(position)

        if (itemRequest != null) {

            holder.bind(itemRequest)

        }
    }

//
//    override fun getItemCount(): Int {
//
//        return items.size
//
//    }

    @Suppress("DEPRECATION")
    inner class MyViewHolder(itemVew: View) : RecyclerView.ViewHolder(itemVew) {

        fun bind(requestBody: GetContent) {

            itemView.apply {

                title_request.text = requestBody.Title
                summary_request.text = requestBody.Summary

                Glide.with(itemView)
                    .load(requestBody.LandscapeImage)
                    .into(itemView.img_request)

            }
        }
    }

    companion object{

        private val PERSON_COMPARATOR = object : DiffUtil.ItemCallback<GetContent>(){

            override fun areItemsTheSame(oldItem: GetContent, newItem: GetContent): Boolean =

                oldItem.ContentID == newItem.ContentID

            override fun areContentsTheSame(oldItem: GetContent, newItem: GetContent): Boolean =

                oldItem == newItem

        }
    }
}
