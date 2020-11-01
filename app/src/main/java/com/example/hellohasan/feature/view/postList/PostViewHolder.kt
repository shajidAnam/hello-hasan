package com.example.hellohasan.feature.view.postList

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*

class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val postImage:AppCompatImageView=itemView.iv_post
    val postTtile:AppCompatTextView=itemView.tv_post_title
    val authorName:AppCompatTextView=itemView.tv_author_value
    val modifiedDate:AppCompatTextView=itemView.tv_modified_date_value
}