package com.martin.myapplication.models

import android.os.Parcel
import android.os.Parcelable

//PARCELABRE sirve para serializar el objeto, deserializar el objeto y volverlo a crear.
//Sirve para intents de objetos!!

//Parcel es un contenedor para un mensaje
//Puede ser usado para mandar un objeto serializado a traves de internet
//Mejor rendimiento que serializer
data class Student (var name: String, var lastName: String, var age: Int, var isDeveloper: Boolean = true) : Parcelable {

    //leemos en el mismo orden en que declaramos las propiedades
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte()) //0.toByte() da un valor booleano (true) y si comparamos y da verdadero, el resultado es verdadero

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //tenemos que escribir los valores en el mismo orden en el que leemos en el constructor
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (isDeveloper) 1 else 0)
    }

    //describe el tipo de contenido del objeto parcelable
    //0 siempre se usa, el otro valor es 1 o CONTENTS_FILE_DESCRIPTOR, y esto es para tipo de objetos que implementan un File Descriptor
    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Student> {

        //creará el objeto desde el parcel llamando al constructor SECUNDARIO
        override fun createFromParcel(parcel: Parcel) = Student(parcel)

        //ayudará a serializar arrays de objetos del mismo objeto que esta clase (Student)
        override fun newArray(size: Int) = arrayOfNulls <Student>(size)

        }
}