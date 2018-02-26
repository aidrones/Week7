package com.bindedittextandbuttontovariable.week7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var txtShow = findViewById<TextView>(R.id.txtShow)
        var strShow: String = intent.getStringExtra("SendInfo")
        txtShow.text = strShow

        val etUserName = findViewById<TextView>(R.id.etUserName)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        //val tvInfo = findViewById<TextView>(R.id.tvInfo)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            var status = if(etUserName.text.toString().equals("name")
                && etPassword.text.toString().equals("password")) "Logged in Successfully "
            else "Login Error "
            Toast.makeText(this, status, Toast.LENGTH_LONG).show()
        }

    }
}
