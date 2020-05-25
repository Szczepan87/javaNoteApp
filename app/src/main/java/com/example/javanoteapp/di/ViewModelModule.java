package com.example.javanoteapp.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.javanoteapp.NoteAppViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(CustomViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(NoteAppViewModel.class)
    abstract ViewModel providesNoteAppViewModel(NoteAppViewModel noteAppViewModel);
}
