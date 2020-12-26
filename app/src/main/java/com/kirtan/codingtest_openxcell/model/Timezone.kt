package com.kirtan.codingtest_openxcell.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Timezone : Parcelable {
    @SerializedName("offset")
    @Expose
    var offset: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    constructor(`in`: Parcel) {
        offset = `in`.readValue(String::class.java.classLoader) as String?
        description = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param offset
     * @param description
     */
    constructor(offset: String?, description: String?) : super() {
        this.offset = offset
        this.description = description
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(offset)
        dest.writeValue(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Timezone> = object : Creator<Timezone> {
            override fun createFromParcel(`in`: Parcel): Timezone {
                return Timezone(`in`)
            }

            override fun newArray(size: Int): Array<Timezone?> {
                return arrayOfNulls(size)
            }
        }
    }
}
