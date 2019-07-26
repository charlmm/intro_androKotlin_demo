package com.charles.intro_androkotlin_demo

import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.net.URL
import java.net.URLConnection

import android.os.Bundle
import android.os.StrictMode
import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.Menu
import android.widget.ImageView

class BasicImageDownloadActivity : Activity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_image_download)
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder().permitNetwork().build()
        )
        downloadImageFromUri("http://2.gravatar.com/avatar/858dfac47ab8176458c005414d3f0c36?s=128&d=&r=G")
    }

    private fun downloadImageFromUri(address: String) {
        var url: URL?
        try {
            url = URL(address)
        } catch (e1: MalformedURLException) {
            url = null
        }

        val conn: URLConnection
        val `in`: InputStream
        var bitmap: Bitmap?
        try {
            conn = url!!.openConnection()
            conn.connect()
            `in` = conn.getInputStream()
            bitmap = BitmapFactory.decodeStream(`in`)
            `in`.close()
        } catch (e: IOException) {
            bitmap = null
        }

        if (bitmap != null) {
            val img = findViewById<ImageView>(R.id.ivBasicImage)
            img.setImageBitmap(bitmap)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_basic_image_download, menu)
        return true
    }

}
