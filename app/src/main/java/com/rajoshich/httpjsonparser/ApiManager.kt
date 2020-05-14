package com.rajoshich.httpjsonparser

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson


class ApiManager (context: Context) {

    private val queue: RequestQueue = Volley.newRequestQueue(context)
    private val context:Context = context

    fun getUsers(onUserReady: (User) -> Unit, onError: (() -> Unit)? = null) {
        val userURL = "https://raw.githubusercontent.com/echeeUW/codesnippets/master/user_info.json"
        val req = StringRequest(
            Request.Method.GET, userURL,
            {response ->
                val gson = Gson()
                val user = gson.fromJson(response, User::class.java)
                onUserReady(user)
            },
            {
                Toast.makeText(context, "error!", Toast.LENGTH_SHORT).show()
            })
        queue.add(req)
    }





}