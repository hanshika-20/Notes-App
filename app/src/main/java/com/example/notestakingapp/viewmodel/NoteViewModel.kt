package com.example.notestakingapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notestakingapp.model.Note
import com.example.notestakingapp.repository.noteRepository
import kotlinx.coroutines.launch

class NoteViewModel(
    app: Application,
    private val noteRepository: noteRepository):
    AndroidViewModel(app)
{
    fun addNote(note: Note)=
        viewModelScope.launch{
            noteRepository.insertNote(note)
        }
    fun deleteNote(note:Note)=
        viewModelScope.launch{
            noteRepository.deleteNote(note)
        }
    fun updateeNote(note:Note)=
        viewModelScope.launch{
            noteRepository.updateNote(note)
        }
    fun getAllNotes()= noteRepository.getAllNotes()
    fun searchNote(query:String?) = noteRepository.searchNote(query)
}