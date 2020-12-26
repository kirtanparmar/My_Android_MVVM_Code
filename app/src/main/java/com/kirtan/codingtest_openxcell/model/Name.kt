package com.kirtan.codingtest_openxcell.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Name : Parcelable {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("first")
    @Expose
    var first: String? = null

    @SerializedName("last")
    @Expose
    var last: String? = null

    constructor(`in`: Parcel) {
        title = `in`.readValue(String::class.java.classLoader) as String?
        first = `in`.readValue(String::class.java.classLoader) as String?
        last = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param last
     * @param title
     * @param first
     */
    constructor(title: String?, first: String?, last: String?) : super() {
        this.title = title
        this.first = first
        this.last = last
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(title)
        dest.writeValue(first)
        dest.writeValue(last)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Name> = object : Creator<Name> {
            override fun createFromParcel(`in`: Parcel): Name {
                return Name(`in`)
            }

            override fun newArray(size: Int): Array<Name?> {
                return arrayOfNulls(size)
            }
        }
    }
}
