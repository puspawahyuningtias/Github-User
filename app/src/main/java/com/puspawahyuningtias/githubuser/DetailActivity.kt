package com.puspawahyuningtias.githubuser

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_user.*

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

        val produk by getParcelableExtra<User>(EXTRA_MYDATA)

        supportActionBar?.title = produk?.userName.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Glide.with(this)
            .load(produk?.photo)
            .apply(RequestOptions().override(200, 200))
            .into(img_avatar)
        tv_nama.text = produk?.nama.toString()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}