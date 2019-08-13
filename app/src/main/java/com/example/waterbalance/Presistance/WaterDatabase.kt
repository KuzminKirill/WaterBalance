package com.example.waterbalance.Presistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.waterbalance.Model.WaterDrinks
import com.example.waterbalance.Model.TiviTypeConverters


@Database(entities = arrayOf(WaterDrinks::class), version = 3)
@TypeConverters(TiviTypeConverters::class)
abstract class WaterDatabase: RoomDatabase() {

    abstract val dao: DAO

    companion object {

        val DATABASE_NAME: String = "water_db"

        private var instance: WaterDatabase? = null

        internal fun getInstance(context: Context?): WaterDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context!!.applicationContext,
                    WaterDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return instance as WaterDatabase
        }
    }
}