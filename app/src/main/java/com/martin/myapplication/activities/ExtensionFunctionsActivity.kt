package com.martin.myapplication.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.martin.myapplication.MainActivity
import com.martin.myapplication.R
import com.martin.myapplication.others.goToActivity
import com.martin.myapplication.others.loadByURL
import com.martin.myapplication.others.snackBar
import com.martin.myapplication.others.toast
import kotlinx.android.synthetic.main.activity_extension_functions.*


class ExtensionFunctionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)

        buttonToast.setOnClickListener { toast("I love extension functions")}
        buttonSnackBar.setOnClickListener { snackBar("I love extension functions", action = "Undo") { toast( "Undo!!")} }
        buttonLoadByURL.setOnClickListener { imageViewLoadedByURL.loadByURL( "http://artattack.es/wp-content/uploads/2016/09/025-Pikachu-2-pokemon-go.png") }
        buttonGoToActivity.setOnClickListener { goToActivity<MainActivity>{putExtra("id", 1)}}
    }
}
