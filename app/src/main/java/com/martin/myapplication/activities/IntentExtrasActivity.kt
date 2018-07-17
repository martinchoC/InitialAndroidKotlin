package com.martin.myapplication.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.martin.myapplication.R
import com.martin.myapplication.models.Student
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        //Boton back que creé, no es el del action bar
        buttonBack.setOnClickListener{startActivity(Intent(this, IntentsActivity :: class.java))}
        val isExtraSet = getIntentExtrasFromPreviousActivity()
        val isParcelableSet = setParcelableExtraFromPreviousActivity()

        if(!isExtraSet && !!isParcelableSet) {
            checkBoxDeveloper.visibility = View.INVISIBLE
        }
    }

    private fun getIntentExtrasFromPreviousActivity() : Boolean{
        val name: String? = intent.getStringExtra("name")
        val lastName: String? = intent.getStringExtra("lastName")
        val age: Int = intent.getIntExtra("age", -1)
        val developer = intent.getBooleanExtra("developer", false)
        if(name != null && lastName != null && age > 0) {
            textViewName.text = name
            textViewLastName.text = lastName
            textViewAge.text = "$age"
            checkBoxDeveloper.text = "Developer"
            checkBoxDeveloper.isChecked = developer
            return true
        }
        return false
    }

    private fun setParcelableExtraFromPreviousActivity() : Boolean{
        val student = intent.getParcelableExtra<Student>("student")
        //if( student != null)    ---> Estilo java
        student?.let{           //---> Estilo Kotlin
            textViewName.text = student.name
            textViewLastName.text = student.lastName
            textViewAge.text = "${student.age}"
            checkBoxDeveloper.text = "Developer"
            checkBoxDeveloper.isChecked = student.isDeveloper
            return true
        }
        return false
    }

}
