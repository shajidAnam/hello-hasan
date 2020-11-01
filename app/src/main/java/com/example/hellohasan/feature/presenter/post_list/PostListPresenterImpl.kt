package com.example.hellohasan.feature.presenter.post_list

import com.example.hellohasan.feature.model.postList.Post
import com.example.hellohasan.feature.model.postList.PostListCallBack
import com.example.hellohasan.feature.model.postList.PostListModel
import com.example.hellohasan.feature.model.postList.PostListModelImpl
import com.example.hellohasan.feature.view.postList.PostListView

class PostListPresenterImpl(private val postListView:PostListView):PostListPresenter {
    private val postListModel:PostListModel=PostListModelImpl()
    override fun getPostList() {
        postListView.handleProgressbarVisibility(true)
        postListModel.getPostList(object :PostListCallBack{
            override fun onSuccess(postList: MutableList<Post>) {
                postListView.handleProgressbarVisibility(false)
                postListView.onPostListFetchSuccess(postList)
            }

            override fun onError(throwable: Throwable) {
                postListView.handleProgressbarVisibility(false)
                if (throwable.localizedMessage!=null)
                    postListView.onPostListFetchFailure(throwable.localizedMessage!!)
                else
                    postListView.onPostListFetchFailure("something went wrong")
            }

        })
    }
}