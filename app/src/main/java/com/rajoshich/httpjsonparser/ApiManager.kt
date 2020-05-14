package com.rajoshich.httpjsonparser

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson


class ApiManager (context: Context) {

    private val queue: RequestQueue = Volley.newRequestQueue(context)

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
                onError?.invoke()
            })
        queue.add(req)
    }





}