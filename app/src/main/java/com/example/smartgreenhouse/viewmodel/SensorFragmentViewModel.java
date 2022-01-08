package com.example.smartgreenhouse.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.smartgreenhouse.model.Client;
import com.example.smartgreenhouse.model.SensorItem;

import java.util.ArrayList;
import java.util.Arrays;

public class SensorFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<SensorItem>> values;

    public SensorFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<ArrayList<SensorItem>> getValues() {
        if (values == null) {
            values = new MutableLiveData<>();
        }
        return values;
    }

    public void refreshValues() {
        Client
        // Fake values
        ArrayList<SensorItem> mockValues = new ArrayList(Arrays.asList(
                new SensorItem("temperature", "25ºC"),
                new SensorItem("light", "70%"),
                new SensorItem("soilMoisture", "58%")
        ));
        values.postValue(mockValues);
    }

}
