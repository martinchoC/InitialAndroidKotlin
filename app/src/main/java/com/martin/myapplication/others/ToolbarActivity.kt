package com.martin.myapplication.others

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.martin.myapplication.models.IToolbar

open class ToolbarActivity : AppCompatActivity(), IToolbar {

    protected var _toolbar: Toolbar? =null

    override fun toolbarToLoad(toolbar: Toolbar?) {
        _toolbar = toolbar
        _toolbar?.let { setSupportActionBar(_toolbar) }
    }

    override fun enableHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)    // ? PORQUE PUEDE SER NULO
    }

}
