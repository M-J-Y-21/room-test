package com.example.roomtut.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtut.R
import com.example.roomtut.data.Marker
import com.example.roomtut.databinding.FragmentAddBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var markerList = emptyList<Marker>()
    // Fix binding
    private var _binding: ListAdapter? = null
    private val binding get() = _binding!!
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: ListAdapter.MyViewHolder, position: Int) {
        val currentItem = markerList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.title_txt.text = currentItem.title.toString()
        holder.itemView.location_txt.text = currentItem.location.toString()
        holder.itemView.colour_txt.text = currentItem.colour.toString()


    }

    override fun getItemCount() = markerList.size

    fun setData(marker: List<Marker>) {
        this.markerList = marker
        notifyDataSetChanged()

    }

    }

