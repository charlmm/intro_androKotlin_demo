package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.app.Activity
import android.view.Menu
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import com.charles.intro_androkotlin_demo.R

class TimePickerDemoActivity : Activity() {

    private var tpTime: TimePicker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker_demo)
        tpTime = findViewById<TimePicker>(R.id.tpTime)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_time_picker_demo, menu)
        return true
    }

    fun displayTime(v: View) {
        val time = tpTime!!.currentHour.toString() + ":" + tpTime!!.currentMinute
        Toast.makeText(this, time, Toast.LENGTH_SHORT).show()
    }

}
