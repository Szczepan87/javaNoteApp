package com.example.javanoteapp.repository;

import androidx.lifecycle.LiveData;

import com.example.javanoteapp.model.Note;

import java.util.List;

import javax.inject.Inject;

public class NoteRepository {

    private NoteDao mNoteDao;

    @Inject
    public NoteRepository(NoteDao mNoteDao) {
        this.mNoteDao = mNoteDao;
    }

    public LiveData<List<Note>> getAllNotes(){
        return this.mNoteDao.getAllNotes();
    }

    public void addNote(Note note){
        this.mNoteDao.addNote(note);
    }
}
