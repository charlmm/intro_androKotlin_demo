package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.view.Menu
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button

class ExplicitIntentActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)
        val btnLaunchSecond = findViewById<Button>(R.id.btnLaunchSecond)
        btnLaunchSecond.setOnClickListener {
            val i = Intent(this@ExplicitIntentActivity, SimpleBundleDemoActivity::class.java)
            i.putExtra("text", "Passed String Extra!")
            startActivity(i)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_explicit_intent, menu)
        return true
    }

}
