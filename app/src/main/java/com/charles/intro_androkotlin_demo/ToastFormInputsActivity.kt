package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.app.Activity
import android.view.Menu
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.charles.intro_androkotlin_demo.R

class ToastFormInputsActivity : Activity() {

    private var etVal: EditText? = null
    private var chkVal: CheckBox? = null
    private var rdgVal: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast_form_inputs)
        etVal = findViewById<EditText>(R.id.etVal)
        chkVal = findViewById<CheckBox>(R.id.chkVal)
        rdgVal = findViewById<RadioGroup>(R.id.rdgVal)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_toast_form_inputs, menu)
        return true
    }

    fun toastInputs(v: View) {
        val selected = rdgVal!!.checkedRadioButtonId
        val b = findViewById<View>(selected) as RadioButton

        val text = etVal!!.text.toString() + " | " + chkVal!!.isChecked + " | " + b.text
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

}
