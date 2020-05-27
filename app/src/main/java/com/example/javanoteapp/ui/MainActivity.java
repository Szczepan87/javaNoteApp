package com.example.javanoteapp.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.javanoteapp.R;
import com.example.javanoteapp.databinding.ActivityMainBinding;
import com.example.javanoteapp.di.CustomViewModelFactory;
import com.example.javanoteapp.di.DaggerAppComponent;
import com.example.javanoteapp.di.modules.AppModule;
import com.example.javanoteapp.di.modules.RoomModule;
import com.example.javanoteapp.model.Note;
import com.example.javanoteapp.utils.NoteRecyclerAdapter;
import com.example.javanoteapp.vm.NoteAppViewModel;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private NoteAppViewModel noteAppViewModel;
    private ActivityMainBinding binding;

    @Inject
    public CustomViewModelFactory vmFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initDagger();

        noteAppViewModel = ViewModelProviders.of(this, vmFactory).get(NoteAppViewModel.class);

        final NoteRecyclerAdapter adapter = new NoteRecyclerAdapter();
        binding.notesRecyclerView.setAdapter(adapter);

        binding.addNoteFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNoteDialog dialog = new CreateNoteDialog(noteAppViewModel);
                dialog.show(getSupportFragmentManager(), "CREATE NOTE");
            }
        });

        noteAppViewModel.getAllNotes().observe(this, new Observer<List<Note>>(){
            @Override
            public void onChanged(List<Note> notes) {
                adapter.updateList(notes);
                // fill the list of recycler
            }
        });
    }

    private void initDagger() {
        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);
    }
}
