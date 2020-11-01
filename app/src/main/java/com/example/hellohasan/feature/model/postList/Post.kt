package com.example.hellohasan.feature.model.postList

import java.io.Serializable

data class Post (
    val id:Int,
    val jetpack_featured_media_url:String,
    val title:Title,
    val author:String,
    val content:Description
    //val modified:String,
):Serializable{
    data class Title(
        val rendered:String
    )
    data class Description(
        val rendered: String
    )
}