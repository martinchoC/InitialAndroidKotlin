package com.martin.myapplication.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.martin.myapplication.R
import com.martin.myapplication.models.Student
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        buttonIntentExtras.setOnClickListener {goIntentExtras()}
        buttonIntentFlags.setOnClickListener {goIntentFlags()}
        buttonIntentObject.setOnClickListener {goIntentObject()}

    }

    private fun goIntentExtras(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra("name", "Martin")
        intent.putExtra("lastName", "Castro")
        intent.putExtra("age", 29)
        intent.putExtra("developer", true)
        startActivity(intent)
    }

    private fun goIntentFlags() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        //OPCION 1
        //NO GUARDA EL ACTIVITY EN EL STACK
        // intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        //OPCION 2
        //mata el activity en lugar de ponerlo en el stack
        //destruye este activity evitando que entre en el stack
        // finish()
        //OPCION 3: ANIMACIONES
        //NO ANIMACION
        // intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
        //OPCION 4
        //BORRA EL STACK COMPLETO
        //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)

    }

    private fun goIntentObject() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        val student = Student("Martin", "Castro", 29, true)
        intent.putExtra("student", student)
        startActivity(intent)
    }
}
