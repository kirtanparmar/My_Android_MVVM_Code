package com.kirtan.codingtest_openxcell.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class APIModel : Parcelable {
    @SerializedName("results")
    @Expose
    var results: List<Result?>? = null

    @SerializedName("info")
    @Expose
    var info: Info? = null

    constructor(`in`: Parcel) {
        `in`.readList(results!!, Result::class.java.classLoader)
        info = `in`.readValue(Info::class.java.classLoader) as Info?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param results
     * @param info
     */
    constructor(results: List<Result?>?, info: Info?) : super() {
        this.results = results
        this.info = info
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeList(results)
        dest.writeValue(info)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Parcelable.Creator<APIModel> = object : Parcelable.Creator<APIModel> {
            override fun createFromParcel(`in`: Parcel): APIModel {
                return APIModel(`in`)
            }

            override fun newArray(size: Int): Array<APIModel?> {
                return arrayOfNulls(size)
            }
        }
    }
}