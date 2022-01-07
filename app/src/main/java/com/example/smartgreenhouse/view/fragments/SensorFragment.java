package com.example.smartgreenhouse.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.SensorItem;
import com.example.smartgreenhouse.view.SensorsAdapter;
import com.example.smartgreenhouse.viewmodel.SensorFragmentViewModel;

import java.util.ArrayList;

/**

 */
public class SensorFragment extends Fragment {
    private SensorFragmentViewModel viewModel;
    private ImageButton refreshSensorsButton;
    private RecyclerView sensorsRecyclerView;
    private SensorsAdapter sensorsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewModel = new ViewModelProvider(this).get(SensorFragmentViewModel.class);
        sensorsAdapter = new SensorsAdapter(getActivity(), new ArrayList<>());
        viewModel.getValues().observe(getActivity(), newList -> onValuesChanged(newList));
        return inflater.inflate(R.layout.fragment_sensor, container, false);
    }

    /*
    As getView() works only after onCreateView(), you can't use it inside
    onCreate() or onCreateView() methods of the fragment.
    */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshSensorsButton = view.findViewById(R.id.refreshSensorsButton);
        refreshSensorsButton.setOnClickListener(clickedView -> onRefreshButtonClicked());
<<<<<<< HEAD
        sensorsRecyclerView = getView().findViewById(R.id.sensorsRecylerView);
        sensorsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
=======
        sensorsRecyclerView = view.findViewById(R.id.sensorsRecylerView);
>>>>>>> edb1894a3def337923593d4f251276a11433c5c2
        sensorsRecyclerView.setAdapter(sensorsAdapter);
    }

    private void onValuesChanged(ArrayList<SensorItem> newList) {
        sensorsAdapter.items = newList;
        sensorsAdapter.notifyDataSetChanged();
    }

    private void onRefreshButtonClicked() {
        viewModel.refreshValues();
    }
}