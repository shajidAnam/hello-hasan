package com.example.hellohasan.network

import com.example.hellohasan.feature.model.postList.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApiInterface {
    @GET("posts")
    fun getPostList():Call<MutableList<Post>>
    @GET("posts/{post_id}")
    fun getPostDetails(@Path("post_id") postid:Int):Call<Post>
}