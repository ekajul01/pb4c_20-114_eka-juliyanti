package com.example.tugaspendahuluan21

import android.os.Parcel
import android.os.Parcelable
data class Data2Class(var name:String, var email:String, var phone:String, var alamat:String
):Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()!!, parcel.readString()!!,
                                        parcel.readString()!!, parcel.readString()!!
    ) {}
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(alamat)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<Data2Class> {
        override fun createFromParcel(parcel: Parcel): Data2Class {
            return Data2Class(parcel)
        }
        override fun newArray(size: Int): Array<Data2Class?> {
            return arrayOfNulls(size)
        }
    }
}
