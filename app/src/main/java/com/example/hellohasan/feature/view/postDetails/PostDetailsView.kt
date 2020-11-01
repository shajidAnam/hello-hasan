package com.example.hellohasan.feature.view.postDetails

import com.example.hellohasan.feature.model.postList.Post

interface PostDetailsView {
    fun handleProgressBarVisibility(isVisible:Boolean)
    fun onPostDetailsFetchSuccess(post: Post)
    fun onPostDetailsFetchError(errorMessage:String)
}