package com.bindedittextandbuttontovariable.week7

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //bind objects
        var txtMessage = findViewById<EditText>(R.id.txtMessage)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        //val txtMessage = findViewById<EditText>(R.id.txtMessage)
        var btnSend = findViewById<Button>(R.id.btnPage2)

        //get focus on txtMessage at runtime
        txtMessage.requestFocus()

        //submit button action
        btnSubmit.setOnClickListener {
            Toast.makeText(this, "The Message is:  ${txtMessage.text.toString()}", Toast.LENGTH_LONG).show()
            //hide keyboard
            //hideKeyboard()
            //clear txtMessage
            txtMessage.setText("")
            //set focus back on txtMessage
            txtMessage.requestFocus()

            btnSend.setOnClickListener(View.OnClickListener {
            //Intent used to send data between activities
            var intent = Intent(this, Main2Activity::class.java)
            //putExtra sets vale to name SendInfo
            intent.putExtra("SendInfo", txtMessage.text.toString())
            //Go to second activity
            startActivity(intent)
        })
            hideKeyboard()
        }
    }


        fun hideKeyboard() {
            try {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }catch (e: Exception){
                // TODO: handle exception
            }

    }
}
