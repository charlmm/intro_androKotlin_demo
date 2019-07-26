package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.app.Activity
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import codepath.apps.demointroandroid.SimpleAlertDialog

class ListViewClicksActivity : Activity() {
    internal var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_clicks)
        val myCountries = arrayOf("United States", "Canada", "Mexico", "Japan")
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, myCountries
        )

        val listView = findViewById<ListView>(R.id.lvDemo)
        listView.adapter = adapter
        listView.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val country = adapter!!.getItem(position)
            SimpleAlertDialog.displayWithOK(this@ListViewClicksActivity, country!!)
            Toast.makeText(this@ListViewClicksActivity, country, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_list_view_clicks, menu)
        return true
    }

}
