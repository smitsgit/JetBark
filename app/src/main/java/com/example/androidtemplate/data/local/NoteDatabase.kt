package com.example.androidtemplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidtemplate.data.local.NoteDao

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "Notesdb"
    }
}