package com.example.waterbalance.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime



@Entity(tableName = "water_drinks")
data class WaterDrinks(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,

    @ColumnInfo(name = "date") val date: OffsetDateTime? = null,

    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "volume") val volume: Int
)


