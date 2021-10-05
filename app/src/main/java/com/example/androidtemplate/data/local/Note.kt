package com.example.androidtemplate.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {

}


class InvalidNoteException(message: String): Exception(message)