package com.example.notestakingapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notestakingapp.repository.noteRepository

class NoteViewModelFactory (
    val app: Application,
    private val noteRepository: noteRepository
    ): ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(app,noteRepository) as T
    }
}