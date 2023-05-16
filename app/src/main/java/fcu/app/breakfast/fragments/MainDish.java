package fcu.app.breakfast.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fcu.app.breakfast.CartActivity;
import fcu.app.breakfast.R;
import fcu.app.breakfast.ViewMenu;


public class MainDish extends Fragment implements View.OnClickListener {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_main_dish, container, false);
        Button addBul = (Button) view.findViewById(R.id.button1);
        addBul.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), CartActivity.class);
        startActivityForResult(intent,0);
    }
}