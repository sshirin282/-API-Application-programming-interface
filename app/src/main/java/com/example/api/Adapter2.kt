package com.example.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.zip.Inflater

class Adapter2(val context: Context?, val list:ArrayList<DataModel2>):
RecyclerView.Adapter<Adapter2.ViewHolder>(){

    private val inflater=context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val image:ImageView=view.findViewById(R.id.image2)
        val id2:TextView=view.findViewById(R.id.id2)
        val name2:TextView=view.findViewById(R.id.name2)
        val status2:TextView=view.findViewById(R.id.status2)
        val species:TextView=view.findViewById(R.id.species2)
        val type:TextView=view.findViewById(R.id.type2)
        val gender:TextView=view.findViewById(R.id.gender2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter2.ViewHolder {
        val rowView=inflater.inflate(R.layout.list2,parent,false)
        return ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: Adapter2.ViewHolder, position: Int) {
     holder.id2.text=list.get(position).id
        holder.name2.text=list.get(position).name
        holder.status2.text=list.get(position).status
        holder.species.text=list.get(position).species
        holder.type.text=list.get(position).type
        holder.gender.text=list.get(position).gender
        context?.let {
            Glide.with(it)
                .load(list.get(position).image)
                .into(holder.image)
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }
}