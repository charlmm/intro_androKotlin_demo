package com.charles.intro_androkotlin_demo

import android.net.Uri
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.view.Menu
import android.view.View
import android.widget.TextView

class ImplicitIntentsActivity : Activity() {

    val uriToVisit: Uri?
        get() {
            var urlAddress: String? = (findViewById<TextView>(R.id.txtUrlAddress)).text.toString()
            if (urlAddress != null) {
                if (!urlAddress.startsWith("http://"))
                    urlAddress = "http://$urlAddress"
                return Uri.parse(urlAddress)
            } else {
                return null
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_implicit_intents, menu)
        return true
    }

    fun visitUrlAddress(v: View) {
        val url = uriToVisit
        if (url != null) {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = url
            startActivity(i)
        }

    }

}
