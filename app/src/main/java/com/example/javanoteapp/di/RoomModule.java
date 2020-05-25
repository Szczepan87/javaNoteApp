package com.example.javanoteapp.di;

import com.example.javanoteapp.repository.NoteDao;
import com.example.javanoteapp.repository.NoteDatabase;
import com.example.javanoteapp.repository.NoteRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private NoteDatabase mNoteDatabase;

    public RoomModule(NoteDatabase mNoteDatabase) {
        this.mNoteDatabase = mNoteDatabase;
    }

    @Singleton
    @Provides
    NoteDatabase providesNoteDatabase() {
        return mNoteDatabase;
    }

    @Singleton
    @Provides
    NoteDao providesNoteDao() {
        return mNoteDatabase.getNoteDao();
    }

    @Singleton
    @Provides
    NoteRepository providesNoteRepository(NoteDao noteDao) {
        return new NoteRepository(noteDao);
    }
}
