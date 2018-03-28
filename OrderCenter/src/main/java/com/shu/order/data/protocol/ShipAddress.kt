package com.shu.order.data.protocol

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/*
   收货地址
 */
@Parcelize
@SuppressLint("ParcelCreator")
data class ShipAddress(
        val id: Int,
        var shipUserName: String,
        var shipUserMobile: String,
        var shipAddress: String,
        var shipIsDefault: Int
) : Parcelable
