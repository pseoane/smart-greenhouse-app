package com.example.smartgreenhouse.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.StatisticItem;
import com.example.smartgreenhouse.view.viewholder.adapters.StatisticAdapter;
import com.example.smartgreenhouse.viewmodel.StatisticFragmentViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatisticsFragment#} factory method to
 * create an instance of this fragment.
 */
public class StatisticsFragment extends Fragment {
    private StatisticFragmentViewModel viewModel;
    private StatisticAdapter statisticsAdapter;
    private ImageButton refreshStatisticsButton;
    private RecyclerView StatisticsRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        viewModel = new ViewModelProvider(this).get(StatisticFragmentViewModel.class);
        statisticsAdapter = new StatisticAdapter(getActivity(), new ArrayList<>());
        viewModel.getValues().observe(getActivity(), newList -> onValuesChanged(newList));
        return inflater.inflate(R.layout.fragment_statistic, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshStatisticsButton = view.findViewById(R.id.refreshStatisticButton);
        refreshStatisticsButton.setOnClickListener(clickedView -> onRefreshButtonClicked());
        StatisticsRecyclerView = getView().findViewById(R.id.statisticsRecylerView);
        StatisticsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        StatisticsRecyclerView = view.findViewById(R.id.statisticsRecylerView);
        StatisticsRecyclerView.setAdapter(statisticsAdapter);
    }

    private void onValuesChanged(ArrayList<StatisticItem> newList) {
        statisticsAdapter.items = newList;
        statisticsAdapter.notifyDataSetChanged();
    }

    private void onRefreshButtonClicked() {
        viewModel.refreshValues();
    }

}