package com.example.javanoteapp.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.javanoteapp.model.Note;
import com.example.javanoteapp.repository.NoteRepository;

import java.util.List;

import javax.inject.Inject;

public class NoteAppViewModel extends ViewModel {

    private NoteRepository mNoteRepository;

    @Inject
    public NoteAppViewModel(NoteRepository mNoteRepository) {
        this.mNoteRepository = mNoteRepository;
    }

    public LiveData<List<Note>> getAllNotes() {
        return mNoteRepository.getAllNotes();
    }

    public void insertNote(Note note) {
        mNoteRepository.addNote(note);
    }
}
