package com.wmt.sajid.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wmt.sajid.databinding.RowRatesBinding
import com.wmt.sajid.models.Example
import com.wmt.sajid.models.Results

class UsersAdapter :
    RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {
    var arrayList: ArrayList<Results>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowRatesBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    init {
        arrayList= ArrayList()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rates=arrayList[position]
        holder.binding.model=rates
        holder.binding.executePendingBindings()
    }

    inner class MyViewHolder(var binding: RowRatesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun setMovieList(movies: ArrayList<Results>) {
        this.arrayList = movies
        notifyDataSetChanged()
    }
}