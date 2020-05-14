package com.rajoshich.httpjsonparser

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class FetchActivity : AppCompatActivity() {
    private val TAG = "rajoshic"

    lateinit var apiManager: ApiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            fetchWithVolley()
            Log.i(TAG, "POOOOO")
        }
    }

    private fun fetchWithVolley() {
        apiManager.getArtists()


    }

//    private fun makeHTTPRequest() {
//      val artistsJSON = URL("https://raw.githubusercontent.com/echeeUW/codesnippets/master/allartists.json").readText()
//        Log.i(TAG, "$artistsJSON")
//    }
//
//    private fun runOnBackgroundTask() {
//        val task = Runnable {
//            makeHTTPRequest()
//        }
//        val backgroundThread = Thread(task)
//        backgroundThread.start()
//    }
}