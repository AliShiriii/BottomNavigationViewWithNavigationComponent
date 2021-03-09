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
import com.example.testapplication.databinding.RowViewBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_view.view.*

class RequestAdapter(private val listener: OnItemClickListener) : PagingDataAdapter<GetContent, RequestAdapter.MyViewHolder>(
   PERSON_COMPARATOR ) {

    interface OnItemClickListener{

        fun onItemClick(content: GetContent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestAdapter.MyViewHolder {

        return MyViewHolder(RowViewBinding.inflate(LayoutInflater.from(parent.context), parent,false))

    }

    override fun onBindViewHolder(holder: RequestAdapter.MyViewHolder, position: Int) {

        val itemRequest = getItem(position)

        if (itemRequest != null) {

            holder.bind(itemRequest)

        }
    }

    @Suppress("DEPRECATION")
    inner class MyViewHolder(val binding : RowViewBinding) : RecyclerView.ViewHolder(binding.root) {

        init {

            itemView.rootView.setOnClickListener {

                val position = bindingAdapterPosition

                if (position != RecyclerView.NO_POSITION){

                    var item = getItem(position)

                    if (item != null){

                        listener.onItemClick(item)

                    }
                }

            }

        }

        fun bind(requestBody: GetContent) {

                binding.titleRequest.text = requestBody.Title
                binding.summaryRequest.text = requestBody.Summary

                Picasso.get().load(requestBody.LandscapeImage)
                    .into(binding.imgRequest)

//                Glide.with(itemView)
//                    .load(requestBody.LandscapeImage)
//                    .into(itemView.img_request)

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
