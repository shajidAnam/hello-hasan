package com.example.hellohasan.feature.model.postList

import com.example.hellohasan.network.PostApiInterface
import com.example.hellohasan.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostListModelImpl():PostListModel {
    private val apiInterface=RetrofitClient.getClient().create(PostApiInterface::class.java)
    private val call=apiInterface.getPostList()
    override fun getPostList(postListCallBack: PostListCallBack) {
        call.enqueue(object :Callback<MutableList<Post>>{
            override fun onResponse(
                call: Call<MutableList<Post>>,
                response: Response<MutableList<Post>>
            ) {
                response.body()?.let {
                    postListCallBack.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                postListCallBack.onError(t)
            }

        })
    }
}