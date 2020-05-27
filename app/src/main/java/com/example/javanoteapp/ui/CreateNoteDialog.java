package com.example.javanoteapp.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.example.javanoteapp.R;
import com.example.javanoteapp.databinding.DialogCreateNoteBinding;
import com.example.javanoteapp.model.Note;
import com.example.javanoteapp.vm.NoteAppViewModel;

import java.util.Objects;

public class CreateNoteDialog extends DialogFragment {

    CreateNoteDialog(NoteAppViewModel viewModel) {
        this.noteAppViewModel = viewModel;
    }

    private DialogCreateNoteBinding binding;
    private NoteAppViewModel noteAppViewModel;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(requireContext()),
                R.layout.dialog_create_note,
                null,
                false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(binding.getRoot());

        setUpBinding(binding);

        return builder.create();
    }

    private void setUpBinding(final DialogCreateNoteBinding binding) {
        binding.setViewModel(noteAppViewModel);

        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        binding.okButton.setOnClickListener(new View.OnClickListener() {
            Thread task = new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.d("DIALOG", getNoteContent());
                    noteAppViewModel.insertNote(new Note(0, getNoteContent()));
                }
            });

            @Override
            public void onClick(View v) {
                task.start();
                dismiss();
            }
        });
    }

    private String getNoteContent() {
        return Objects.requireNonNull(binding.noteContentEditText.getText()).toString();
    }
}
