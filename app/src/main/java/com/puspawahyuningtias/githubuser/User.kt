package com.puspawahyuningtias.githubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var userName: String = "",
    var nama: String = "",
    var photo: Int = 0
): Parcelable