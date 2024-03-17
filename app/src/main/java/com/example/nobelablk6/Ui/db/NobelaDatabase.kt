package com.example.nobelablk6.Ui.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nobelablk6.Ui.models.NobelaResponseItem


@Database(
    entities = [NobelaResponseItem::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class NobelaDatabase: RoomDatabase() {

    abstract fun getNobelaDao(): NobelaDAO

    companion object{
        @Volatile
        private var instance: NobelaDatabase? = null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock){
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NobelaDatabase::class.java,
                "nobela_db.db"
            ).build()
    }
}