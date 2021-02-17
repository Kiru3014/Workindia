package com.workindia.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.workindia.R
import com.workindia.api.ApiClient
import com.workindia.api.ApiInterface
import com.workindia.model.FeedModel
import com.workindia.model.ListData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var navigation: BottomNavigationView
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationSetUp()
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        apiListCall("c676c89c-8910-4ffd-a762-a0bb2a747dad")
    }

    private fun apiListCall(path: String) {

        val apiService = ApiClient.client?.create(ApiInterface::class.java)
        val call = apiService?.getFeedData(path)
        call?.enqueue(object : Callback<FeedModel> {
            override fun onResponse(call: Call<FeedModel>, response: Response<FeedModel>) {
                if (response.isSuccessful) {
                    val feedModel = response.body();
                    if (feedModel != null) {
                        if (feedModel.listData != null) {
                            if (feedModel.listData!!.istiled == true) {
                                renderTiledData(feedModel.listData)
                            }else{
                                renderData(feedModel.listData)
                            }
                        }
                    }
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Please Try After Some Time",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<FeedModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Please Try After Some Time", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    private fun renderData(listData: ListData?) {
        val adapter = MyListAdapter(listData, this)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun renderTiledData(listData: ListData?) {
        val adapter = MyListAdapter(listData, this)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }


    private fun bottomNavigationSetUp() {
        try {
            navigation = findViewById<View>(R.id.nav_view) as BottomNavigationView
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        } catch (e: Exception) {
        }
    }


    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.navigation_one -> {
                    apiListCall("c676c89c-8910-4ffd-a762-a0bb2a747dad")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_two -> {
                    apiListCall("1ef320cf-73c8-4ac7-9b2e-040ba622b8b4")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_three -> {
                    apiListCall("793604cd-5291-45c6-925a-91a013759892")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_four -> {
                    apiListCall("1ef320cf-73c8-4ac7-9b2e-040ba622b8b4")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_five -> {
                    apiListCall("c676c89c-8910-4ffd-a762-a0bb2a747dad")
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
}