package com.martin.myapplication.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.martin.myapplication.R
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*   //No necesito hacer mas findViewById

class KotlinAndroidExtensionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)

        //Click by ID, i.e. using findViewById
        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener { Toast.makeText(this, "Click by ID!", Toast.LENGTH_SHORT).show() }

        //Click by KAT, i.e. using kotlinx extension library
        buttonByKAT.setOnClickListener { Toast.makeText(this, "Click by KAT!", Toast.LENGTH_SHORT).show() }


    }
}
