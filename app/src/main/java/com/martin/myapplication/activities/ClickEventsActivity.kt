package com.martin.myapplication.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.martin.myapplication.R


class ClickEventsActivity : AppCompatActivity(), View.OnLongClickListener {

    // 1) Click en XML
    // 2) Click en linea
    // 3) Click by IDS en ´when´

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)

        clickInLine()

        val btn1 = findViewById<Button>(R.id.buttonClickMulti1)
        val btn2 = findViewById<Button>(R.id.buttonClickMulti2)
        val btn3 = findViewById<Button>(R.id.buttonClickMulti3)

        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }

    //FORMA MENOS ACONSEJABLE!!!
    //NO DEBERÍA TENER LOGICA DEL CODIGO EN EL XML!!!
    //Regla obligatoria para clicks en XML:
    //El metodo debe ser público, los nombres tienen que coincidir y recibe un solo parámetro (View)
    fun xmlClick (view: View){
        Toast.makeText(this, "Click by XML", Toast.LENGTH_SHORT).show()
    }

    private fun clickInLine(){
        val btn = findViewById<Button>(R.id.buttonClickInLine)
        btn.setOnClickListener { Toast.makeText(this, "Click in line", Toast.LENGTH_SHORT).show() }
        //Si necesito acceder a la view, uso lambda expressions
        //btn.setOnClickListener { view -> Toast.makeText(this, "Click by XML", Toast.LENGTH_LONG).show() }

    }

    override fun onLongClick(view: View): Boolean {
        when(view.id) {
            R.id.buttonClickMulti1 -> Toast.makeText(this, "Click Multi 1!", Toast.LENGTH_SHORT).show()
            R.id.buttonClickMulti2 -> Toast.makeText(this, "Click Multi 2!", Toast.LENGTH_SHORT).show()
            R.id.buttonClickMulti3 -> Toast.makeText(this, "Click Multi 3!", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
