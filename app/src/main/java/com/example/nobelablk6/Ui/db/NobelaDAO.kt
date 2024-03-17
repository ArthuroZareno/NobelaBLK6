package com.example.nobelablk6.Ui.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nobelablk6.Ui.models.NobelaResponseItem


@Dao
interface NobelaDAO {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsert(nobelaResponseItem: NobelaResponseItem): Long

   @Query("SELECT * FROM nobela")
   fun getAllNobela(): LiveData<List<NobelaResponseItem>>

   @Delete
   suspend fun deleteNobela(nobelaResponseItem: NobelaResponseItem)
}