package com.example.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter1(val context: Context?, val list:ArrayList<DataModel1>)
    :RecyclerView.Adapter<Adapter1.ViewHolder>() {

    private val inflater=context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val user:TextView=view.findViewById(R.id.userid)
        val id:TextView=view.findViewById(R.id.id)
        val title:TextView=view.findViewById(R.id.title)
        val body:TextView=view.findViewById(R.id.body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter1.ViewHolder {
        val rowView=inflater.inflate(R.layout.list1,parent,false)
        return ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: Adapter1.ViewHolder, position: Int) {
     holder.user.text=list.get(position).userId
        holder.id.text=list.get(position).id
        holder.title.text=list.get(position).title
        holder.body.text=list.get(position).body
    }

    override fun getItemCount(): Int {
        return list.size
    }
}