package com.kirtan.codingtest_openxcell.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Location : Parcelable {
    @SerializedName("street")
    @Expose
    var street: Street? = null

    @SerializedName("city")
    @Expose
    var city: String? = null

    @SerializedName("state")
    @Expose
    var state: String? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("postcode")
    @Expose
    var postcode: String? = null

    @SerializedName("coordinates")
    @Expose
    var coordinates: Coordinates? = null

    @SerializedName("timezone")
    @Expose
    var timezone: Timezone? = null

    constructor(`in`: Parcel) {
        street = `in`.readValue(Street::class.java.classLoader) as Street?
        city = `in`.readValue(String::class.java.classLoader) as String?
        state = `in`.readValue(String::class.java.classLoader) as String?
        country = `in`.readValue(String::class.java.classLoader) as String?
        postcode = `in`.readValue(String::class.java.classLoader) as String?
        coordinates = `in`.readValue(Coordinates::class.java.classLoader) as Coordinates?
        timezone = `in`.readValue(Timezone::class.java.classLoader) as Timezone?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param country
     * @param city
     * @param street
     * @param timezone
     * @param postcode
     * @param coordinates
     * @param state
     */
    constructor(
        street: Street?,
        city: String?,
        state: String?,
        country: String?,
        postcode: String?,
        coordinates: Coordinates?,
        timezone: Timezone?
    ) : super() {
        this.street = street
        this.city = city
        this.state = state
        this.country = country
        this.postcode = postcode
        this.coordinates = coordinates
        this.timezone = timezone
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(street)
        dest.writeValue(city)
        dest.writeValue(state)
        dest.writeValue(country)
        dest.writeValue(postcode)
        dest.writeValue(coordinates)
        dest.writeValue(timezone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Location> = object : Creator<Location> {
            override fun createFromParcel(`in`: Parcel): Location {
                return Location(`in`)
            }

            override fun newArray(size: Int): Array<Location?> {
                return arrayOfNulls(size)
            }
        }
    }
}