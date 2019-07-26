package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.view.Menu
import android.view.View
import android.widget.EditText

class SimpleReturnResultActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_return_result)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_simple_return_result, menu)
        return true
    }

    fun sendResult(v: View) {
        val result = (findViewById<EditText>(R.id.txtRandomResultText)).text.toString()
        val i = Intent()
        i.putExtra("result", result)
        setResult(Activity.RESULT_OK, i)
        finish()
    }

}
