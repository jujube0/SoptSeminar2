package com.example.soptseminar2.webToon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soptseminar2.R


class WebtAdapter(private val context: Context):RecyclerView.Adapter<WebtViewHolder>() {
    var datas = mutableListOf<WebtData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_webtoon, parent,false)
        val width: Int = parent.getMeasuredWidth() / 3
        view.layoutParams.width = width
        view.requestLayout()
        return WebtViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: WebtViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}