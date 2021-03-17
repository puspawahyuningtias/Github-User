package com.puspawahyuningtias.githubuser

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_user.img_avatar
import kotlinx.android.synthetic.main.item_user.tv_nama

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MYDATA = "extra_mydata"
    }

    private inline fun <reified T : Parcelable> Activity.getParcelableExtra(key: String) = lazy {
        intent.getParcelableExtra<T>(key)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val user by getParcelableExtra<User>(EXTRA_MYDATA)

        supportActionBar?.title = user?.userName.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Glide.with(this)
            .load(user?.photo)
            .apply(RequestOptions().override(200, 200))
            .into(img_avatar)
        tv_nama.text = user?.nama.toString()
        tv_followers.text = user?.followers.toString()
        tv_following.text = user?.following.toString()
        tv_repository.text = user?.repository.toString()
        tv_location.text = user?.location.toString()
        tv_company.text = user?.company.toString()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}