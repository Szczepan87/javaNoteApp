package com.example.javanoteapp.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.javanoteapp.vm.NoteAppViewModel;
import com.example.javanoteapp.di.CustomViewModelFactory;
import com.example.javanoteapp.di.ViewModelKey;

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
