package com.example.nobelablk6.Ui.repository

import com.example.nobelablk6.Ui.api.RetrofitInstance
import com.example.nobelablk6.Ui.db.NobelaDatabase
import com.example.nobelablk6.Ui.models.NobelaResponseItem

class NobelaRepository(val db: NobelaDatabase) {

    suspend fun getNobela(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getNobela(countryCode, pageNumber)

    suspend fun searchNobela(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNobela(searchQuery, pageNumber)

    suspend fun upsert(nobelaResponseItem: NobelaResponseItem) = db.getNobelaDao().upsert(nobelaResponseItem)

    fun getFavouriteNobela() = db.getNobelaDao().getAllNobela()

    suspend fun deleteNobela(nobelaResponseItem: NobelaResponseItem) = db.getNobelaDao().deleteNobela(nobelaResponseItem)
}