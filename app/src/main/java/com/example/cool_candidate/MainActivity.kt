package com.example.cool_candidate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerValues : Array<String> = arrayOf("Android Developer","C++ Developer","Web Developer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, spinnerValues)
        spinner_jobtittle.adapter = spinnerAdapter
        //val previewButton: Button = findViewById<Button>(R.id.submit_button)
        submit_button.setOnClickListener{
            onPreviewClick()

        }
    }

    private fun onPreviewClick() {
        val phoneNum = phone_text?.text.toString()
        val displayName = displayName_text?.text.toString()
        val contactName = name_text?.text.toString()
        val checkedJunior = checkbox_junior?.isChecked
        val dateText = date_text?.text.toString()
        val imStart = immediateStart?.isChecked
        val jobTittle = spinner_jobtittle.selectedItem?.toString()

       // val testString = "name: $contactName phone: $phoneNum Display Name: $displayName" + checkbox_junior?.isChecked + "" + spinner_jobtittle.selectedItem?.toString() + date_text?.text.toString()
       //Toast.makeText(this, testString, Toast.LENGTH_LONG).show()


        val myMessage = Message(phone_text?.text.toString(),name_text?.text.toString(),displayName_text?.text.toString(), spinner_jobtittle.selectedItem?.toString(),date_text?.text.toString(), immediateStart?.isChecked, checkbox_junior?.isChecked)

        val previewIntent = Intent(applicationContext, PreviewActivity::class.java)
        previewIntent.putExtra("message",  myMessage)

        startActivity(previewIntent)


    }
}