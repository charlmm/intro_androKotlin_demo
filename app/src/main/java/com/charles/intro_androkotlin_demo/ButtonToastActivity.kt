package com.charles.intro_androkotlin_demo

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_button_toast.*

class ButtonToastActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_toast)
        btnToast.setOnClickListener {v -> textClicked(v)}
    }

    private fun textClicked(v: View) {
        Toast.makeText(this, "you clicked me", Toast.LENGTH_SHORT ).show()
    }
}