package com.kirtan.codingtest_openxcell.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Street : Parcelable {
    @SerializedName("number")
    @Expose
    var number: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    constructor(`in`: Parcel) {
        number = `in`.readValue(String::class.java.classLoader) as String?
        name = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param number
     * @param name
     */
    constructor(number: String?, name: String?) : super() {
        this.number = number
        this.name = name
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(number)
        dest.writeValue(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Street> = object : Creator<Street> {
            override fun createFromParcel(`in`: Parcel): Street {
                return Street(`in`)
            }

            override fun newArray(size: Int): Array<Street?> {
                return arrayOfNulls(size)
            }
        }
    }
}