package com.example.nobelablk6.Ui.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "nobela"
)

data class NobelaResponseItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val body: String,
    val created_at: String,
    val description: String,
    val genre: String,
    val image: String,
    val rating: String,
    val title: String,
    val updated_at: String
):Serializable