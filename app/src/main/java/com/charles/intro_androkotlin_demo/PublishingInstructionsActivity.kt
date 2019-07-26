package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.app.Activity
import android.view.Menu
import com.charles.intro_androkotlin_demo.R

class PublishingInstructionsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publishing_instructions)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater
            .inflate(R.menu.activity_publishing_instructions, menu)
        return true
    }

}
