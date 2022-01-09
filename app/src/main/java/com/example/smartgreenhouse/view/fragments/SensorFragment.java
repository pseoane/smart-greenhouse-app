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
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.SensorItem;
import com.example.smartgreenhouse.view.viewholder.adapters.SensorsAdapter;
import com.example.smartgreenhouse.viewmodel.SensorFragmentViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**

 */
public class SensorFragment extends Fragment {
    private SensorFragmentViewModel viewModel;
    private ImageButton refreshSensorsButton;
    private RecyclerView sensorsRecyclerView;
    private SensorsAdapter sensorsAdapter;
    private final String URL = "https://srv-iot.diatel.upm.es/api/plugins/telemetry/ASSET/9ae70ea0-6bb1-11ec-9a04-591db17ccd5b/values/timeseries?keys=currentValueHum,currentValueL,currentValuepH,currentValueSM,currentValueTemp";

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
        sensorsRecyclerView = getView().findViewById(R.id.sensorsRecylerView);
        sensorsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        sensorsRecyclerView = view.findViewById(R.id.sensorsRecylerView);
        sensorsRecyclerView.setAdapter(sensorsAdapter);
    }

    private void onValuesChanged(ArrayList<SensorItem> newList) {
        sensorsAdapter.items = newList;
        sensorsAdapter.notifyDataSetChanged();
    }

    private void onRefreshButtonClicked() { viewModel.refreshValues(); }


}