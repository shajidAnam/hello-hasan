package com.example.hellohasan.feature.view.postList

import com.example.hellohasan.feature.model.postList.Post

interface PostListView {
    fun onPostListFetchSuccess(postList: MutableList<Post>)
    fun onPostListFetchFailure(errorMessage:String)
    fun handleProgressbarVisibility(isVisible:Boolean)
}