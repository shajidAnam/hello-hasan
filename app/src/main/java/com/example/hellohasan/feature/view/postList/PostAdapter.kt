package com.example.hellohasan.feature.view.postList

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hellohasan.R
import com.example.hellohasan.feature.model.postList.Post

class PostAdapter(private val postList:MutableList<Post>,private val itemClickListener:onClickListener):RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post=postList[position]
        holder.authorName.text="Hasan Abdullah"
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            holder.postTtile.text=(Html.fromHtml(post.title.rendered,Html.FROM_HTML_MODE_LEGACY))
        }
        else {
            holder.postTtile.text=(Html.fromHtml(post.title.rendered))
        }
        //holder.postTtile.text=post.title.rendered
        // holder.modifiedDate.text=post.modifiedDate
        Glide.with(holder.postImage)
            .load(post.jetpack_featured_media_url)
            .into(holder.postImage)
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClickListener(position)
        }
    }
    override fun getItemCount(): Int {
       return postList.size
    }
}