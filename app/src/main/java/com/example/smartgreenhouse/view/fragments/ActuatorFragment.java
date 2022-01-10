package com.example.smartgreenhouse.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.viewmodel.ActuatorFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActuatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActuatorFragment extends Fragment {

    private ActuatorFragmentViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actuator, container, false);
    }
}