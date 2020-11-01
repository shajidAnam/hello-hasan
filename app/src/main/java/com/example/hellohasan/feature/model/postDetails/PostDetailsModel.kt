package com.example.hellohasan.feature.model.postDetails

interface PostDetailsModel {
    fun getPostDetails(id: Int,postDetailsCallBack:PostDetailsCallBack)
}