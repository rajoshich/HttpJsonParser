package com.rajoshich.httpjsonparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.text.HtmlCompat
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var listOfArtists: AllArtist
    lateinit var apiManager: ApiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiManager = (application as HttpApp).apiManager

            apiManager.getArtists({ allArtist ->
                listOfArtists = allArtist
                val list = listOfArtists.artists
                button.visibility = View.VISIBLE
                button.text = HtmlCompat.fromHtml(list[0].name, HtmlCompat.FROM_HTML_MODE_LEGACY)
            })


//            , {
//            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
//        })

        }
    }



