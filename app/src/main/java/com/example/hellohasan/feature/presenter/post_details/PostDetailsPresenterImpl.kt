package com.example.hellohasan.feature.presenter.post_details

import com.example.hellohasan.feature.model.postDetails.PostDetailsCallBack
import com.example.hellohasan.feature.model.postDetails.PostDetailsModel
import com.example.hellohasan.feature.model.postDetails.PostDetailsModelImpl
import com.example.hellohasan.feature.model.postList.Post
import com.example.hellohasan.feature.view.postDetails.PostDetailsView

class PostDetailsPresenterImpl(private val postDetailsView: PostDetailsView):PostDetailsPresenter {
    private val postDetailsModel:PostDetailsModel=PostDetailsModelImpl()
    override fun getPostDetails(id: Int) {
        postDetailsView.handleProgressBarVisibility(true)
        postDetailsModel.getPostDetails(id,object :PostDetailsCallBack{
            override fun onSuccess(postDetails: Post) {
                postDetailsView.handleProgressBarVisibility(false)
                postDetailsView.onPostDetailsFetchSuccess(postDetails)
            }

            override fun onError(throwable: Throwable) {
                if (throwable.localizedMessage!=null)
                    postDetailsView.onPostDetailsFetchError(throwable.localizedMessage)
                else
                    postDetailsView.onPostDetailsFetchError("Something went wrong")
            }

        })
    }
}