package com.example.testapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapplication.Entity.ContentEntity
import com.example.testapplication.R
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

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(contentEntity: ContentEntity){

            itemView.apply {

                title_request.text = contentEntity.Title
                summary_request.text = contentEntity.Summary

                Glide.with(itemView)
                    .load(contentEntity.Image)
                    .into(itemView.img_request)


            }

            itemView.rootView.setOnClickListener {

                onItemClickCallBack?.callBack(contentEntity)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_favorite, parent, false)

        return MyViewHolder(view)    }

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