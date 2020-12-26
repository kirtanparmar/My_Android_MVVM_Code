package com.kirtan.codingtest_openxcell.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Dob : Parcelable {
    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("age")
    @Expose
    var age: String? = null

    constructor(`in`: Parcel) {
        date = `in`.readValue(String::class.java.classLoader) as String?
        age = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param date
     * @param age
     */
    constructor(date: String?, age: String?) : super() {
        this.date = date
        this.age = age
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(date)
        dest.writeValue(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Dob> = object : Creator<Dob> {
            override fun createFromParcel(`in`: Parcel): Dob {
                return Dob(`in`)
            }

            override fun newArray(size: Int): Array<Dob?> {
                return arrayOfNulls(size)
            }
        }
    }
}