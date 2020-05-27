package com.example.javanoteapp.di;

import android.app.Application;

import com.example.javanoteapp.ui.MainActivity;
import com.example.javanoteapp.di.modules.AppModule;
import com.example.javanoteapp.di.modules.RoomModule;
import com.example.javanoteapp.di.modules.ViewModelModule;
import com.example.javanoteapp.repository.NoteDao;
import com.example.javanoteapp.repository.NoteDatabase;
import com.example.javanoteapp.repository.NoteRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {}, modules = {AppModule.class,
        RoomModule.class,
        ViewModelModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    NoteDao noteDao();

    NoteDatabase noteDatabase();

    NoteRepository noteRepository();

    Application application();
}
