package com.charles.intro_androkotlin_demo

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.preference.PreferenceActivity
import android.view.Menu
import android.widget.ImageView

import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.BinaryHttpResponseHandler

import cz.msebera.android.httpclient.Header

class SmartImageDownloadActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_image_download)
        downloadSmartImageFromUrl("http://2.gravatar.com/avatar/858dfac47ab8176458c005414d3f0c36?s=128&d=&r=G")
    }

    private fun downloadSmartImageFromUrl(address: String) {
        val client = AsyncHttpClient()
        client.get(address, object : BinaryHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, binaryData: ByteArray?) {
                val bitmap = BitmapFactory.decodeByteArray(binaryData, 0, binaryData!!.size)
                val img = findViewById<ImageView>(R.id.ivSmartImage)
                img.setImageBitmap(bitmap)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                binaryData: ByteArray?,
                error: Throwable?
            ) {
                error?.printStackTrace()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_smart_image_download, menu)
        return true
    }

}
