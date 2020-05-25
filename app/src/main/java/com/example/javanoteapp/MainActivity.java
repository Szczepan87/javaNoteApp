package com.example.javanoteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import com.example.javanoteapp.di.AppModule;
import com.example.javanoteapp.di.CustomViewModelFactory;
import com.example.javanoteapp.di.DaggerAppComponent;
import com.example.javanoteapp.di.RoomModule;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    private NoteAppViewModel noteAppViewModel;

    @Inject
    public CustomViewModelFactory vmFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);

        noteAppViewModel = ViewModelProviders.of(this, vmFactory).get(NoteAppViewModel.class);
    }
}
