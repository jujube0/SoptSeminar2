package com.example.soptseminar2.webToon

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soptseminar2.R
import kotlinx.android.synthetic.main.item_webtoon.view.*

class WebtViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val img=view.findViewById<ImageView>(R.id.webt_item_imgv)
    val title=view.findViewById<TextView>(R.id.webt_item_title)
    val author=view.findViewById<TextView>(R.id.webt_item_author)
    val layout=view.findViewById<LinearLayout>(R.id.webt_item_linearlayout)


    fun bind(data:WebtData){
        title.text=data.title
        author.text=data.author
        Glide.with(itemView).load(data.img_url).into(img)

    }

}