package com.rajoshich.httpjsonparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var listOfArtists: AllArtist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiManager = (application as HttpApp).apiManager

        apiManager.getArtists({ allArtist ->
             listOfArtists = allArtist

        }, {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        })
        val list = listOfArtists.artists
        button.text = list[0].name
    }

    fun fetchDataWithGson() {
       // val gson = Gson()
//        val artist: Artist = gson.fromJson(listOfArtists, Artist::class.java)

    }


}
