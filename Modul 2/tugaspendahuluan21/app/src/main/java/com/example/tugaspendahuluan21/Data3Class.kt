package com.example.tugaspendahuluan21

import android.os.Parcel
import android.os.Parcelable
data class Data3Class(var namedepan:String, var namebelakang:String,
                      var email:String, var password:String, var konfpassword:String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {}
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(namedepan)
        parcel.writeString(namebelakang)
        parcel.writeString(email)
        parcel.writeString(password)
        parcel.writeString(konfpassword)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<Data3Class> {
        override fun createFromParcel(parcel: Parcel): Data3Class {
            return Data3Class(parcel)
        }
        override fun newArray(size: Int): Array<Data3Class?> {
            return arrayOfNulls(size)
        }
    }
}

