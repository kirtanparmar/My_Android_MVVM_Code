package com.kirtan.codingtest_openxcell.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Coordinates : Parcelable {
    @SerializedName("latitude")
    @Expose
    var latitude: String? = null

    @SerializedName("longitude")
    @Expose
    var longitude: String? = null

    constructor(`in`: Parcel) {
        latitude = `in`.readValue(String::class.java.classLoader) as String?
        longitude = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param latitude
     * @param longitude
     */
    constructor(latitude: String?, longitude: String?) : super() {
        this.latitude = latitude
        this.longitude = longitude
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(latitude)
        dest.writeValue(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Coordinates> = object : Creator<Coordinates> {
            override fun createFromParcel(`in`: Parcel): Coordinates {
                return Coordinates(`in`)
            }

            override fun newArray(size: Int): Array<Coordinates?> {
                return arrayOfNulls(size)
            }
        }
    }
}