package com.charles.intro_androkotlin_demo

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.ArrayList

import cz.msebera.android.httpclient.HttpResponse
import cz.msebera.android.httpclient.HttpStatus
import cz.msebera.android.httpclient.StatusLine
import cz.msebera.android.httpclient.client.ClientProtocolException
import cz.msebera.android.httpclient.client.HttpClient
import cz.msebera.android.httpclient.client.methods.HttpGet
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient

class ProgressBarActivity : Activity() {

    internal var pb: ProgressBar? = null
    internal var tvResult: TextView? = null
    internal var lines = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)
        pb = findViewById<ProgressBar>(R.id.pgDownloading)
        tvResult = findViewById<TextView>(R.id.txtUrlOutput)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_progress_bar, menu)
        return true
    }

    fun startFourUrlAsync(v: View) {
        DelayTask().execute()
    }

    inner class DelayTask : AsyncTask<Void, Int, String>() {
        internal var count = 0
        override fun onPreExecute() {
            pb!!.visibility = ProgressBar.VISIBLE
        }

        override fun doInBackground(vararg params: Void): String {
            var res = loadUrlBody("http://google.com")
            lines.add(res!!.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0])
            publishProgress(25)
            res = loadUrlBody("http://yahoo.com")
            lines.add(res!!.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0])
            publishProgress(50)
            res = loadUrlBody("http://twitter.com")
            lines.add(res!!.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0])
            publishProgress(75)
            res = loadUrlBody("http://facebook.com")
            lines.add(res!!.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0])
            publishProgress(100)
            return "complete"
        }

        private fun onProgressUpdate(vararg values: Int) {
            pb!!.progress = values[0]
        }

        override fun onPostExecute(result: String) {
            Toast.makeText(this@ProgressBarActivity, "Completed!", Toast.LENGTH_SHORT).show()
            tvResult!!.text = lines.toString()
        }

        private fun loadUrlBody(address: String): String? {
            val httpclient = DefaultHttpClient()
            var response: HttpResponse? = null
            var responseString: String? = null
            try {
                response = httpclient.execute(HttpGet(address))
                val statusLine = response!!.getStatusLine()
                if (statusLine.getStatusCode() === HttpStatus.SC_OK) {
                    val out = ByteArrayOutputStream()
                    response!!.getEntity().writeTo(out)
                    out.close()
                    responseString = out.toString()
                } else {
                    response!!.getEntity().getContent().close()
                    throw IOException(statusLine.getReasonPhrase())
                }
            } catch (e: ClientProtocolException) {
            } catch (e: IOException) {
            }

            return responseString
        }

    }

}
