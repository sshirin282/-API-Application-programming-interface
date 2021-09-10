package com.example.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import com.bumptech.glide.Glide

class Adapter3(val context: Context? , val list:ArrayList<DataModel2>)
    :BaseAdapter(){

    private val inflater=context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView=inflater.inflate(R.layout.grid,parent,false)
        val image3: ImageView =rowView.findViewById(R.id.image3)
        val id3: TextView =rowView.findViewById(R.id.id3)
        val name3: TextView =rowView.findViewById(R.id.name3)
        val status3: TextView =rowView.findViewById(R.id.status3)
        val species3: TextView =rowView.findViewById(R.id.species3)
        val type3: TextView =rowView.findViewById(R.id.type3)
        val gender3: TextView =rowView.findViewById(R.id.gender3)


        id3.text=list.get(position).id
        name3.text=list.get(position).name
        status3.text=list.get(position).status
        species3.text=list.get(position).species
        type3.text=list.get(position).type
        gender3.text=list.get(position).gender

        context?.let {
            Glide.with(it)
                .load(list.get(position).image)
                .into(image3)
        }
        return rowView


    }

//    private val inflater=context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

//    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
//        val image: ImageView =view.findViewById(R.id.image3)
//        val id3: TextView =view.findViewById(R.id.id3)
//        val name3: TextView =view.findViewById(R.id.name3)
//        val status3: TextView =view.findViewById(R.id.status3)
//        val species3: TextView =view.findViewById(R.id.species3)
//        val type3: TextView =view.findViewById(R.id.type3)
//        val gender3: TextView =view.findViewById(R.id.gender3)
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter3.ViewHolder {
//        val rowView=inflater.inflate(R.layout.grid,parent,false)
//        return Adapter3.ViewHolder(rowView)
//    }
//
//    override fun onBindViewHolder(holder: Adapter3.ViewHolder, position: Int) {
//        holder.id3.text = list.get(position).id
//        holder.name3.text = list.get(position).name
//        holder.status3.text = list.get(position).status
//        holder.species3.text = list.get(position).species
//        holder.type3.text = list.get(position).type
//        holder.gender3.text = list.get(position).gender
//        context?.let {
//            Glide.with(it)
//                .load(list.get(position).image)
//                .into(holder.image)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
}