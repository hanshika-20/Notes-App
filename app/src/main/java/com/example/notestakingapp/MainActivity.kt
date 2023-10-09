package com.example.notestakingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notestakingapp.database.NoteDatabase
import com.example.notestakingapp.databinding.ActivityMainBinding
import com.example.notestakingapp.repository.noteRepository
import com.example.notestakingapp.viewmodel.NoteViewModel
import com.example.notestakingapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()

    }

    private fun setUpViewModel() {
        val noteRepository= noteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application,noteRepository)
        noteViewModel= ViewModelProvider(
            this,
            viewModelProviderFactory).get(NoteViewModel::class.java)
    }
}