package com.example.propertymanagementmobileapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.propertymanagementmobileapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        button_login.setOnClickListener(this)
        button_sign_up.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            button_login -> {
                startActivity(Intent(this,LoginActivity::class.java))
            }
            button_sign_up -> {
                startActivity(Intent(this,RegisterActivity::class.java))
            }
        }
    }
}