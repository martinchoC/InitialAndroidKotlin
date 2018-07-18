package com.martin.myapplication.models

import android.support.v7.widget.Toolbar

interface IToolbar {

    fun toolbarToLoad(toolbar: Toolbar?)
    fun enableHomeDisplay(value: Boolean)
}