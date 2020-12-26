package com.kirtan.codingtest_openxcell.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Id : Parcelable {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("value")
    @Expose
    var value: String? = null

    constructor(`in`: Parcel) {
        name = `in`.readValue(String::class.java.classLoader) as String?
        value = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param name
     * @param value
     */
    constructor(name: String?, value: String?) : super() {
        this.name = name
        this.value = value
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(name)
        dest.writeValue(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Id> = object : Creator<Id> {
            override fun createFromParcel(`in`: Parcel): Id {
                return Id(`in`)
            }

            override fun newArray(size: Int): Array<Id?> {
                return arrayOfNulls(size)
            }
        }
    }
}
