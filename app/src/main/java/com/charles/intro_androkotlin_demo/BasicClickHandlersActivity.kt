package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.app.Activity
import android.view.Menu
import android.view.View
import android.widget.Button
import codepath.apps.demointroandroid.SimpleAlertDialog

class BasicClickHandlersActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_click_handlers)
        val secondButton = findViewById<Button>(R.id.btnClick2)
        secondButton.setOnClickListener { v -> secondButtonClicked(v) }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_basic_click_handlers, menu)
        return true
    }

    fun firstButtonClicked(v: View) {
        SimpleAlertDialog.displayWithOK(this, "firstButton clicked via XML handler")
    }

    private fun secondButtonClicked(v: View) {
        SimpleAlertDialog.displayWithOK(this, "secondButton clicked via Java handler in onCreate")
    }

}
