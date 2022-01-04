package com.example.recyclerview01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview01.R_Adapter.viewHolder1
import com.google.android.material.button.MaterialButton

class R_Adapter(val details : ArrayList<dummy>,private val onClick: onClick) : RecyclerView.Adapter<viewHolder1>() {


/*  private val details = ArrayList<String>()

    fun addDetails( details : ArrayList<String>){
        this.details.addAll(details)

    }*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder1 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout, parent, false)
        return viewHolder1(view)
    }

    override fun onBindViewHolder(holder: viewHolder1, position: Int) {
        val state = details[position]
        holder.bind(state)
        holder.itemView.setOnClickListener {
            onClick.viewClicked(position)
        }
        holder.btn.setOnClickListener {
            onClick.btnClicked(position)
        }
        holder.favBtn.setOnClickListener {
            onClick.favClicked(position)
        }

    }

    override fun getItemCount(): Int {
        return details.size
    }

    inner class viewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text1 = itemView.findViewById<TextView>(R.id.Tv10)
        val text2 = itemView.findViewById<TextView>(R.id.Tv20)
        val img = itemView.findViewById<ImageView>(R.id.image10)
        val btn = itemView.findViewById<MaterialButton>(R.id.btn1)
        val favBtn = itemView.findViewById<ImageView>(R.id.favorite)

         fun bind(detail:dummy){
             text1.text = detail.name
             text2.text = detail.desc
             img.setImageResource(detail.imagesrc)
             val setIcon = if(detail.favorite) R.drawable.fav else R.drawable.unfav
             favBtn.setImageResource(setIcon)

         }
    }
}
