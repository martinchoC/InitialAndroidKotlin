package com.martin.myapplication.app

import android.app.Application
import com.martin.myapplication.others.MySharedPreferences

//lazy loading:carga floja: si nadie accede a esta variable, esta nunca se va a ejecutar, no va a ocupar memoria
val  preferences: MySharedPreferences by lazy { MyApp.prefs!! }  //!! estoy seguro que nunca va a ser null

class MyApp: Application() {

    companion object {
        var prefs: MySharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences(applicationContext)

    }

}