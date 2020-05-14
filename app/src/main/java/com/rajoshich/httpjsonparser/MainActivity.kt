package com.rajoshich.httpjsonparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var apiManager: ApiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiManager = (application as HttpApp).apiManager
        var count = 0

        button.setOnClickListener {
            apiManager.getUsers({ user ->
                name.visibility = View.VISIBLE
                userName.visibility = View.VISIBLE
                platform.visibility = View.VISIBLE
                nose.visibility = View.VISIBLE
                userImage.visibility = View.VISIBLE
                val fullname = user.firstName + " " + user.lastName
                name.text = fullname
                userName.text = user.username
                nose.text = "Has nose?: ${user.hasNose}"
                platform.text = "Platform: ${user.platform}"
                Glide.with(this).load("https://picsum.photos/seed/voldemort/256").into(userImage)
                count ++
                counter.text = "Clicked Count: ${count}"
            })
        }


        }
    }



