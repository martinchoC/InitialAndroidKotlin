package com.martin.myapplication.others

import android.content.Context

class MySharedPreferences (context: Context) {

    //Nombre del fichero shared preferences
    private val fineName = "mis_preferencias"
    //Instancia del fichero
    private val prefs = context.getSharedPreferences(fineName, Context.MODE_PRIVATE)
    //Por cada una de las variables que vamos a guardar en nuestro fichero shared preferences
    var name: String
        get() = prefs.getString("name", "")
        set(value) = prefs.edit().putString("name", value).apply()

    var age: Int
        get() = prefs.getInt("age", -1)
        set(value) = prefs.edit().putInt("age", value).apply()
}