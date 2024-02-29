package com.example.marvelmovies

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Marvel(
    val name: String?,
    val description: String?,
    val photos: String?,
    val sinopsis: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    companion object : Parceler<Marvel> {

        override fun Marvel.write(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeString(description)
            parcel.writeString(photos)
            parcel.writeString(sinopsis)
        }

        override fun create(parcel: Parcel): Marvel {
            return Marvel(parcel)
        }
    }
}
