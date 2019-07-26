package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.app.Activity
import android.view.Menu

class LinearLayoutDemoActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout_demo)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_linear_layout_demo, menu)
        return true
    }

}
