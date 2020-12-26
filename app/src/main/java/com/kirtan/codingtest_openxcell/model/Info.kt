package com.kirtan.codingtest_openxcell.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Info : Parcelable {
    @SerializedName("seed")
    @Expose
    var seed: String? = null

    @SerializedName("results")
    @Expose
    var results: String? = null

    @SerializedName("page")
    @Expose
    var page: String? = null

    @SerializedName("version")
    @Expose
    var version: String? = null

    constructor(`in`: Parcel) {
        seed = `in`.readValue(String::class.java.classLoader) as String?
        results = `in`.readValue(String::class.java.classLoader) as String?
        page = `in`.readValue(String::class.java.classLoader) as String?
        version = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param seed
     * @param page
     * @param results
     * @param version
     */
    constructor(seed: String?, results: String?, page: String?, version: String?) : super() {
        this.seed = seed
        this.results = results
        this.page = page
        this.version = version
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(seed)
        dest.writeValue(results)
        dest.writeValue(page)
        dest.writeValue(version)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Info> = object : Creator<Info> {
            override fun createFromParcel(`in`: Parcel): Info {
                return Info(`in`)
            }

            override fun newArray(size: Int): Array<Info?> {
                return arrayOfNulls(size)
            }
        }
    }
}