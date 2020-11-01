package com.example.hellohasan.feature.view.postDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.hellohasan.R
import com.example.hellohasan.core.BaseActivity
import com.example.hellohasan.feature.model.postList.Post
import com.example.hellohasan.feature.presenter.post_details.PostDetailsPresenter
import com.example.hellohasan.feature.presenter.post_details.PostDetailsPresenterImpl
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_post_details.*
import kotlinx.android.synthetic.main.toolbar.*

class PostDetailsActivity : BaseActivity(),PostDetailsView {
    override fun setToolbar(): Toolbar {
        toolbar.title=getString(R.string.postDetails)
        return toolbar
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_post_details
    }

    override val isHomeButtonEnabled: Boolean
        get() = true

    private lateinit var postDetailsPresenter: PostDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id=getIntent().getIntExtra("post_id",0)
        postDetailsPresenter=PostDetailsPresenterImpl(this)
        postDetailsPresenter.getPostDetails(id)

    }

    override fun handleProgressBarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress?.visibility=View.VISIBLE
        else
            progress?.visibility=View.GONE
    }

    override fun onPostDetailsFetchSuccess(post: Post) {
        Glide.with(iv_post)
            .load(post.jetpack_featured_media_url)
            .into(iv_post)
        tv_author_value.text="Hasan Abdullah"
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            tv_post_title.text=(Html.fromHtml(post.title.rendered,Html.FROM_HTML_MODE_LEGACY))
            tv_description.text=(Html.fromHtml(post.content.rendered,Html.FROM_HTML_MODE_LEGACY))
        }
        else {
            tv_description.text=(Html.fromHtml(post.content.rendered))
            tv_post_title.text=(Html.fromHtml(post.title.rendered))
        }


    }

    override fun onPostDetailsFetchError(errorMessage: String) {
        showShortToast(errorMessage)
    }
}