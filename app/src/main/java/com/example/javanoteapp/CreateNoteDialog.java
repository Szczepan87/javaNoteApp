package com.example.javanoteapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.example.javanoteapp.databinding.DialogCreateNoteBinding;
import com.example.javanoteapp.model.Note;

import java.util.Objects;

public class CreateNoteDialog extends DialogFragment {

    public CreateNoteDialog(NoteAppViewModel viewModel) {
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

    private void setUpBinding(DialogCreateNoteBinding binding) {
        binding.setViewModel(noteAppViewModel);

        final String noteContent = Objects.requireNonNull(binding.noteContentEditText.getText()).toString();

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
                    noteAppViewModel.insertNote(new Note(0, noteContent));
                }
            });
            @Override
            public void onClick(View v) {
                task.start();
                dismiss();
            }
        });
    }
}
