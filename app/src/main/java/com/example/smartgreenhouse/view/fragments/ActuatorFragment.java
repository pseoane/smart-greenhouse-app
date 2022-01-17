package com.example.smartgreenhouse.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.ActuatorItem;
import com.example.smartgreenhouse.model.SensorItem;
import com.example.smartgreenhouse.view.viewholder.adapters.ActuatorsAdapter;
import com.example.smartgreenhouse.view.viewholder.adapters.SensorsAdapter;
import com.example.smartgreenhouse.viewmodel.ActuatorFragmentViewModel;
import com.example.smartgreenhouse.viewmodel.SensorFragmentViewModel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActuatorFragment newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActuatorFragment extends Fragment {

    private ActuatorFragmentViewModel viewModel;
    private ImageButton refreshStatusButton;
    private RecyclerView actuatorsRecyclerView;
    private ActuatorsAdapter actuatorsAdapter;
    HashMap<String, Integer> actuatorIcons = new HashMap<>();
  //  int[] actuatorIcons = {R.drawable.lamp, R.drawable.irrigation, R.drawable.airconditioner};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actuatorIcons.put("SMART LIGHT SYSTEM", R.drawable.lamp);
        actuatorIcons.put("SMART IRRIGATION SYSTEM", R.drawable.irrigation);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewModel = new ViewModelProvider(this).get(ActuatorFragmentViewModel.class);
        actuatorsAdapter = new ActuatorsAdapter(getActivity(), new ArrayList<>(), actuatorIcons);
        viewModel.getValues().observe(getActivity(), newList -> onValuesChanged(newList));
        return inflater.inflate(R.layout.fragment_actuator, container, false);
    }

    /*
    As getView() works only after onCreateView(), you can't use it inside
    onCreate() or onCreateView() methods of the fragment.
    */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshStatusButton = view.findViewById(R.id.refreshActuatorsButton);
        refreshStatusButton.setOnClickListener(clickedView -> onRefreshButtonClicked());
        actuatorsRecyclerView = getView().findViewById(R.id.actuatorsRecylerView);
        actuatorsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        actuatorsRecyclerView = view.findViewById(R.id.actuatorsRecylerView);
        actuatorsRecyclerView.setAdapter(actuatorsAdapter);
    }

    private void onValuesChanged(ArrayList<ActuatorItem> newList) {
        actuatorsAdapter.items = newList;
        actuatorsAdapter.notifyDataSetChanged();
    }

    private void onRefreshButtonClicked() { viewModel.refreshStatusValues(); }


}