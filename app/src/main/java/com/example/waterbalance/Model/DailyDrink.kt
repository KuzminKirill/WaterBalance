package com.example.waterbalance.Model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import java.time.OffsetDateTime
import java.util.*

@Parcelize
@Entity (tableName = "daily_drink")
data class DailyDrink(
    @ColumnInfo(name = "date") val date: OffsetDateTime? = null,
    @ColumnInfo(name="sum") val sum: Int? = null
) : Parcelable