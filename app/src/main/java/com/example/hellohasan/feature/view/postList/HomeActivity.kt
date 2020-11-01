package com.example.hellohasan.feature.view.postList

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hellohasan.R
import com.example.hellohasan.core.BaseActivity
import com.example.hellohasan.feature.model.postList.Post
import com.example.hellohasan.feature.presenter.post_list.PostListPresenter
import com.example.hellohasan.feature.presenter.post_list.PostListPresenterImpl
import com.example.hellohasan.feature.view.postDetails.PostDetailsActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeActivity :BaseActivity(),PostListView {
    override fun setToolbar(): Toolbar {
        toolbar.title=getString(R.string.app_name)
       return toolbar
    }
    override fun setLayoutId(): Int {
        return R.layout.activity_home
    }
    override val isHomeButtonEnabled: Boolean
        get() = false
    private lateinit var postListPresenter: PostListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postListPresenter=PostListPresenterImpl(this)
        postListPresenter.getPostList()
    }

    override fun onPostListFetchSuccess(postList: MutableList<Post>) {
        initAdapter(postList)
    }



    override fun onPostListFetchFailure(errorMessage: String) {
        showShortToast(errorMessage)
    }

    override fun handleProgressbarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility= View.VISIBLE
        else
            progress.visibility= View.GONE

    }
    private fun initAdapter(postList: MutableList<Post>) {
        val adapter=PostAdapter(postList,object :onClickListener{
            override fun onItemClickListener(position: Int) {
                val intent= Intent(this@HomeActivity,PostDetailsActivity::class.java)
                val id=postList[position].id
                intent.putExtra("post_id",id)
                startActivity(intent)
            }
        })
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter=adapter
        }

    }
