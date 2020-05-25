package com.example.javanoteapp.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.javanoteapp.model.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NoteDao getNoteDao();
}
