package com.example.javanoteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.javanoteapp.repository.NoteRepository;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
