package com.rajoshich.httpjsonparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var listOfArtists:List<Artist>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiManager = (application as HttpApp).apiManager

        apiManager.getArtists({ allArtist ->
             listOfArtists = allArtist.artists

        }, {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        })
    }

//    fun fetchDataWithGson() {
//        val gson = Gson()
//        val artist: Artist = gson.fromJson(listOfArtists, AllArtist::class.java)
//        button.text = artist
//    }

    private fun fetchJson() {
        try {
            val jsonObject = JSONObject(listOfArtists)
            val name = jsonObject.g

        }
    }
}
