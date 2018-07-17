package com.martin.myapplication.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.martin.myapplication.R

class LifeCycleActivity : LifeCycleEventsActivity() {

    private var exitEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

    override fun onBackPressed() {
        if(exitEnabled)
            super.onBackPressed()
        exitEnabled = true
        Toast.makeText(this, "Click back again to exit this screen", Toast.LENGTH_SHORT).show()
        Handler().postDelayed(Runnable { exitEnabled = false }, 2000)
    }
}
