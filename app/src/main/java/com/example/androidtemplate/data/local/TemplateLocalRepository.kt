package com.example.androidtemplate.data.local

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.androidtemplate.domain.TemplateLocalRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TemplateLocalRepository @Inject constructor(val dao: NoteDao): TemplateLocalRepo {

    override fun getNotes(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNoteById(id: Int): Note? {
        TODO("Not yet implemented")
    }

    override suspend fun addNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }
}