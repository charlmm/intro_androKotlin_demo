package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.provider.ContactsContract
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.TextView
import android.widget.Toast

class IntentWithResultActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_result)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_intent_with_result, menu)
        return true
    }

    fun enterText(v: View) {
        startActivityForResult(
            Intent(this@IntentWithResultActivity, SimpleReturnResultActivity::class.java),
            GET_RESULT_TEXT
        )
    }

    // Handle the result once the activity returns a result, display contact
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                val tvResult = findViewById<TextView>(R.id.txtDisplayResult)
                tvResult.text = data.getStringExtra("result")
                Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {

        internal val GET_RESULT_TEXT = 0
    }

}
