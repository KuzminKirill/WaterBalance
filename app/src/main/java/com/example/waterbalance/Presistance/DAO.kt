package com.example.waterbalance.Presistance

import androidx.room.*
import com.example.waterbalance.Model.DailyDrink
import com.example.waterbalance.Model.WaterDrinks
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData



@Dao
interface DAO {

    @Insert
    suspend fun insertDrinks(waterDrinks: WaterDrinks)

    @Query("SELECT date, sum(volume) FROM water_drinks WHERE date BETWEEN :data_start and :data_end GROUP BY date")
    fun getWeekWater(data_start: String, data_end:String): List<DailyDrink>

    @Delete
    fun deleteDrink(vararg drink: WaterDrinks)

    @Update
    fun updateDrink(vararg drink: WaterDrinks)

    @Query("SELECT * FROM water_drinks")
    fun getAllDrinks(): LiveData<List<WaterDrinks>>

}