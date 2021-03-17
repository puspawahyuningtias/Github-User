package com.puspawahyuningtias.githubuser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_user.setHasFixedSize(true)
        list.addAll(getListUsers())
        showRecyclerList()
    }

    @SuppressLint("ResourceType", "Recycle")
    fun getListUsers(): ArrayList<User> {
        val dataUserName = resources.getStringArray(R.array.username)
        val dataNama = resources.getStringArray(R.array.name)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataCompany = resources.getStringArray(R.array.company)
        val listMyData = ArrayList<User>()
        for (position in dataUserName.indices) {
            val myData = User(
                dataUserName[position],
                dataNama[position],
                dataPhoto.getResourceId(position, 0),
                dataFollowers[position],
                dataFollowing[position],
                dataRepository[position],
                dataLocation[position],
                dataCompany[position]
            )
            listMyData.add(myData)
        }
        return listMyData
    }

    private fun showRecyclerList() {
        rv_user.layoutManager = LinearLayoutManager(this)
        val listMyDataAdapter = ListUserAdapter(list, this@MainActivity)
        rv_user.adapter = listMyDataAdapter
    }

}