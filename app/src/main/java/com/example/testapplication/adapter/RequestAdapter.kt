package com.example.testapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.Model.GetContent
import com.example.testapplication.Model.ResultRequest
import com.example.testapplication.R
import kotlinx.android.synthetic.main.row_view.view.*

class RequestAdapter() : RecyclerView.Adapter<RequestAdapter.MyViewHolder>() {


    private var items = ArrayList<GetContent>()

    fun setData(item: ArrayList<GetContent>?){

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

    inner class MyViewHolder(itemVew : View) :RecyclerView.ViewHolder(itemVew){

        fun bind(resultRequest: GetContent) {

            itemView.apply {

                    title_request.text = resultRequest.Title.toString()
                    summary_request.text = resultRequest.Summary.toString()

            }
        }

    }

}
