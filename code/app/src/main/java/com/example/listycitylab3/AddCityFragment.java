package com.example.listycitylab3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddCityFragment extends DialogFragment {

    interface AddCityDialogListener {
        void addCity(City city);
    }

    private AddCityDialogListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof AddCityDialogListener) {
            listener = (AddCityDialogListener) context;
        } else {
            throw new RuntimeException(context + " must implement AddCityDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.fragment_add_city, null);
        EditText addCityName = view.findViewById(R.id.add_text_city_text);
        EditText addProvinceName = view.findViewById(R.id.add_text_province_text);
        AlertDialog.Builder addBuilder = new AlertDialog.Builder(getContext());
        return addBuilder
                .setView(view)
                .setTitle("Add a City")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Add", (dialog, which) -> {
                    String cityName = addCityName.getText().toString();
                    String provinceName = addProvinceName.getText().toString();
                    listener.addCity(new City(cityName, provinceName));
                })
                .create();
    }
}
