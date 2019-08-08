package com.example.waterbalance.Presistance

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import com.example.waterbalance.Model.DailyDrink
import com.example.waterbalance.Model.WaterDrinks


class WaterRepository(context: Context) {

    private lateinit var mWaterDatabase: WaterDatabase
    private lateinit var mDailyDrink: DailyDrink

    init {
        mWaterDatabase = WaterDatabase.getInstance(context)

    }

    fun insertTask(waterDrink: WaterDrinks) {

    }

    fun updateTask(waterDrink: WaterDrinks) {

    }

    fun retrieveTask(): LiveData<List<WaterDrinks>>? {

        return mWaterDatabase.dao.getAllDrinks()
    }

    fun weekTask(data_start: String, data_end:String): List<DailyDrink> { //
        return mWaterDatabase.dao.getWeekWater(data_start, data_end)
    }

    fun deleteTask(waterDrink: WaterDrinks) {

    }
}



