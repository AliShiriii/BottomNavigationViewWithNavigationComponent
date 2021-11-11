package com.example.testapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapplication.Entity.ContentEntity
import com.example.testapplication.R
import com.example.testapplication.databinding.FragmentFavoriteBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_view.view.*

class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>() {

    interface OnItemClickCallBack{

        fun callBack(contentEntity: ContentEntity)
    }

    private var onItemClickCallBack : OnItemClickCallBack? = null

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack){

        this.onItemClickCallBack = onItemClickCallBack

    }

    private var list = emptyList<ContentEntity>()

    fun setList(list: List<ContentEntity>){

        this.list = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: FragmentFavoriteBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(contentEntity: ContentEntity){

              binding.titleRequest.text = contentEntity.Title
                binding.summaryRequest.text = contentEntity.Summary

            Picasso.get().load(contentEntity.Image)
                .into(binding.imgRequest)
//                Glide.with(itemView)
//                    .load(contentEntity.Image)
//                    .into(binding.imgRequest)


            itemView.rootView.setOnClickListener {

                onItemClickCallBack?.callBack(contentEntity)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(FragmentFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val items = list[position]

        if (position != null){

            holder.bind(items)
        }
    }

    override fun getItemCount(): Int {

        return list.size

    }
}
