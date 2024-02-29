package com.example.marvelmovies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelmovies.databinding.ItemRowMarvelBinding

@Suppress("DEPRECATION")
class ListMarvelAdapter(private val listMarvel: ArrayList<Marvel>): RecyclerView.Adapter<ListMarvelAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =  ItemRowMarvelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listMarvel.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photos, sinopsis) = listMarvel[position]
        Glide.with(holder.itemView.context)
            .load(photos)
            .into(holder.binding.imgMarvelIcon)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("extra_detail", listMarvel[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(var binding: ItemRowMarvelBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}