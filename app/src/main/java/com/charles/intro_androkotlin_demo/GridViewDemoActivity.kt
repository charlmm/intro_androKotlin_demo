package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.app.Activity
import android.content.Context
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ImageView

class GridViewDemoActivity : Activity() {

    internal var gvImages: GridView? = null
    internal var adapter: GridImageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view_demo)
        populateGridViewImages()
    }

    private fun populateGridViewImages() {
        gvImages = findViewById<GridView>(R.id.gvImages)
        val numbers = arrayOf("ad", "ae", "af", "ag", "ai", "al")
        adapter = GridImageAdapter(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        gvImages!!.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_grid_view_demo, menu)
        return true
    }

    internal inner class GridImageAdapter(context: Context, textViewResourceId: Int, numbers: Array<String>) :
        ArrayAdapter<String>(context, textViewResourceId, numbers) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val v = ImageView(this@GridViewDemoActivity)
            val resId = resources.getIdentifier(getItem(position), "drawable", packageName)
            v.setImageDrawable(resources.getDrawable(resId))
            return v
        }

    }

}
