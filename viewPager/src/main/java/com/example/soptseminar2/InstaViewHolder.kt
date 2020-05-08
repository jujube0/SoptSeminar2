package com.example.soptseminar2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class InstaViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    val img : ImageView = itemView.findViewById<ImageView>(R.id.image_main)
    val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
    val tv_content = itemView.findViewById<TextView>(R.id.tv_content)

    // InstaData를 받아서 itemView에 넣어주는 함수
    fun bind(instaData : InstaData){
        tv_title.text = instaData.title
        tv_content.text=instaData.content
        Glide.with(itemView).load(instaData.img_url).into(img)
    }
}