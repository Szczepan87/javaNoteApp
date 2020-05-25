package com.example.javanoteapp.di;

import android.app.Application;

import androidx.room.Room;

import com.example.javanoteapp.repository.NoteDao;
import com.example.javanoteapp.repository.NoteDatabase;
import com.example.javanoteapp.repository.NoteRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private NoteDatabase noteDatabase;

    public RoomModule(Application mApplication) {
        noteDatabase = Room.databaseBuilder(mApplication, NoteDatabase.class, "note-db")
                .build();
    }

    @Singleton
    @Provides
    NoteDatabase providesNoteDatabase() {
        return noteDatabase;
    }

    @Singleton
    @Provides
    NoteDao providesNoteDao() {
        return noteDatabase.getNoteDao();
    }

    @Singleton
    @Provides
    NoteRepository providesNoteRepository(NoteDao noteDao) {
        return new NoteRepository(noteDao);
    }
}
