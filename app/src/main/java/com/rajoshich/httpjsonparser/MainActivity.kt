package com.rajoshich.httpjsonparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var apiManager: ApiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiManager = (application as HttpApp).apiManager

        button.setOnClickListener {
            apiManager.getUsers({ user ->
                val fullname = user.first + user.last
                name.text = fullname
                userName.text = user.username


            })
        }


        }
    }



