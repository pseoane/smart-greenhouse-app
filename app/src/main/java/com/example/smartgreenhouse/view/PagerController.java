package com.example.smartgreenhouse.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.smartgreenhouse.view.fragments.ActuatorFragment;
import com.example.smartgreenhouse.view.fragments.SensorFragment;
import com.example.smartgreenhouse.view.fragments.StatisticsFragment;

public class PagerController extends FragmentStateAdapter {
    int numoftabs = 3;

    public PagerController(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return  new SensorFragment();
            case 1:
                return new ActuatorFragment();
            case 2:
                return new StatisticsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return numoftabs;
    }
}
