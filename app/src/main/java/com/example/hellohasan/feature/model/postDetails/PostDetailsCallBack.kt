package com.example.hellohasan.feature.model.postDetails

import com.example.hellohasan.feature.model.postList.Post

interface PostDetailsCallBack {
    fun onSuccess(postDetails:Post)
    fun onError(throwable: Throwable)
}