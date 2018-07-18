package com.martin.myapplication.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.martin.myapplication.R
import com.martin.myapplication.app.preferences
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        buttonSave.setOnClickListener { setValuesSharedPreferences(); cleanEditTexts(); getValuesSharedPreferences();}
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences() {
        if (preferences.name.isNotEmpty() && preferences.age >= 0) { //Hay datos guardados
            textViewSharedPreferences.text = "Welcome ${preferences.name}, your age is ${preferences.age}"
        }
        else{
            textViewSharedPreferences.text = "Welcome. Please save your name and age."
        }
    }

    private fun setValuesSharedPreferences() {
        if(editTextName.text.toString().isNotEmpty() && editTextAge.text.toString().isNotEmpty()){
            preferences.name = editTextName.text.toString()
            preferences.age = editTextAge.text.toString().toInt()
            Toast.makeText(this, "Values have been saved successfully", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Please fill the name and age before saving", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cleanEditTexts() {
        //Forma 1: CLEAR
        editTextName.text.clear()
        //Forma 2: COMILLAS
        editTextAge.setText("")
    }

}
