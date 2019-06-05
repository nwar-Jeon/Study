package com.nwar.individual.serialization

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(val id : Int, val name : String) : Parcelable

/*data class Data (val id : Int, val name : String) : Parcelable{
    companion object CREATOR : Parcelable.Creator<Data>{
        override fun createFromParcel(source: Parcel): Data {
            return Data(source)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }
    constructor(src: Parcel) : this(src.readInt(), src.readString())

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(id)
        dest?.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }
}*/