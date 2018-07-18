package com.martin.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.martin.myapplication.models.Person
import com.martin.myapplication.others.inflate
import kotlinx.android.synthetic.main.list_view_person.view.*

class PersonAdapter (val context: Context, val layout: Int, val list: List<Person>) : BaseAdapter() {

    //no es necesario con las extension functions
    //private val mInflator: LayoutInflater = LayoutInflater.from(context)

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
        val vHolder: PersonViewHolder

        if(convertView == null) { //first time always convertView is null
            //cambio con las extension functions
            //view = mInflator.inflate(layout, parent, false)
            //nueva forma con las extension functions...
            view = parent.inflate(layout)
            vHolder = PersonViewHolder(view)
            view.tag = vHolder
        }
        else {
            view = convertView
            vHolder = view.tag as PersonViewHolder
        }

        val fullName = "${list[position].firstName}, ${list[position].lastName}"
        vHolder.fullName.text = fullName
        vHolder.age.text = "${list[position].age}"

        return view
    }

}

private class PersonViewHolder (view: View) {
    val fullName: TextView = view.textViewName
    val age: TextView = view.textViewAge
}