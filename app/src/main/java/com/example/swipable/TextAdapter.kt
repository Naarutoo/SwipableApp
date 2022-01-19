package com.example.swipable

import Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class TextAdapter(val list: ArrayList<Data>): RecyclerView.Adapter<TextAdapter.TextViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val data = list[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(data:Data){
            itemView.apply {
                textId.text = data.id
                TextDesc.text = data.text
            }
        }
    }
}