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

    fun getArtists(onArtistReady: (AllArtist) -> Unit, onError: (() -> Unit)? = null) {
        val artistsURL = "https://raw.githubusercontent.com/echeeUW/codesnippets/master/allartists.json"
        val req = StringRequest(
            Request.Method.GET, artistsURL,
            {response ->

                val gson = Gson()
                val allArtists = gson.fromJson(response, AllArtist::class.java)
                onArtistReady(allArtists)

            },
            {
//                val context: Context = this
                Toast.makeText(context, "error!", Toast.LENGTH_SHORT).show()
            })
        queue.add(req)
    }





}