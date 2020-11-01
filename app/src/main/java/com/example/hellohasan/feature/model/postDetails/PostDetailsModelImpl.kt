package com.example.hellohasan.feature.model.postDetails

import com.example.hellohasan.feature.model.postList.Post
import com.example.hellohasan.network.PostApiInterface
import com.example.hellohasan.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Path

class PostDetailsModelImpl():PostDetailsModel {
    val postDetailsApiInterface=RetrofitClient.getClient().create(PostApiInterface::class.java)

    override fun getPostDetails(id:Int,postDetailsCallBack: PostDetailsCallBack) {
        val call=postDetailsApiInterface.getPostDetails(id)
        call.enqueue(object :Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                response.body()?.let {
                    postDetailsCallBack.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                postDetailsCallBack.onError(t)
            }

        })
    }
}