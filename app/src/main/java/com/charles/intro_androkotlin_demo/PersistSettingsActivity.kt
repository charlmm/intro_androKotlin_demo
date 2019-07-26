package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.app.Activity
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.view.Menu
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class PersistSettingsActivity : Activity() {

    internal var prefs: SharedPreferences? = null
    internal var edits: Editor? = null
    internal var txtPersist: TextView? = null
    internal var chkPersist: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persist_settings)
        txtPersist = findViewById<TextView>(R.id.txtPersistText)
        chkPersist = findViewById<CheckBox>(R.id.chkPersistState)
        prefs = getSharedPreferences("view", 0)
        edits = prefs!!.edit()
        populateValues()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_persist_settings, menu)
        return true
    }

    private fun populateValues() {
        val persistedText = prefs!!.getString("txtVal", "None Stored Yet")
        val isChecked = prefs!!.getBoolean("chkState", false)
        txtPersist!!.text = persistedText
        chkPersist!!.isChecked = isChecked
    }

    fun persistValues(v: View) {
        edits!!.putString("txtVal", txtPersist!!.text.toString())
        edits!!.putBoolean("chkState", chkPersist!!.isChecked)
        edits!!.commit()
        Toast.makeText(this, "Persisted!", Toast.LENGTH_SHORT).show()
    }

}
