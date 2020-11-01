package com.example.hellohasan.feature.model.postList

interface PostListCallBack {
    fun onSuccess(postList:MutableList<Post>)
    fun onError(throwable: Throwable)
}