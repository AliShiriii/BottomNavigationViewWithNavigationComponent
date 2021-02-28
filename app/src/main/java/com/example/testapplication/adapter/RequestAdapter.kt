package com.example.testapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapplication.Model.GetContent
import com.example.testapplication.Model.RequestBody
import com.example.testapplication.R
import kotlinx.android.synthetic.main.row_view.view.*

class RequestAdapter() : RecyclerView.Adapter< RequestAdapter.MyViewHolder> () {


    private var items = emptyList<RequestBody>()

    fun setData(item: List<RequestBody>?){

        if (item != null) {
            items = item
        }

        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestAdapter.MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_view, parent, false)

        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: RequestAdapter.MyViewHolder, position: Int) {

        val itemRequest = items[position]

        if (itemRequest != null){

            holder.bind(itemRequest)

        }
    }

    override fun getItemCount(): Int {

       return items.size

    }

    @Suppress("DEPRECATION")
    inner class MyViewHolder(itemVew : View) :RecyclerView.ViewHolder(itemVew){

        fun bind(requestBode: RequestBody) {

            itemView.apply {

                title_request.text = requestBode.result.getContentList[adapterPosition].title
                summary_request.text = requestBode.result.getContentList[adapterPosition].summary

                Glide.with(itemView)
                    .load(requestBode.result.getContentList[adapterPosition].landscapeImage)
                    .into(itemView.img_request)

            }
        }

    }
//
//    companion object{
//
//        private val PERSON_COMPARATOR = object : DiffUtil.ItemCallback<RequestBody>(){
//            override fun areItemsTheSame(oldItem: RequestBody, newItem: RequestBody): Boolean =
//
//                oldItem.Result.GetContentList[0].ContentID == newItem.Result.GetContentList[0].ContentID
//
//            override fun areContentsTheSame(oldItem: RequestBody, newItem: RequestBody): Boolean =
//
//                oldItem == newItem
//
//        }
//    }
}
