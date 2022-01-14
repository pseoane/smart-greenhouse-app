package com.example.smartgreenhouse.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.smartgreenhouse.model.ActuatorItem;
import com.example.smartgreenhouse.model.SensorItem;

import java.util.ArrayList;
import java.util.Arrays;

public class ActuatorFragmentViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<ActuatorItem>> statusValues;

    public ActuatorFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<ArrayList<ActuatorItem>> getValues() {
        if (statusValues == null) {
            statusValues = new MutableLiveData<>();
        }
        return statusValues;
    }

    public void refreshStatusValues(){
        ArrayList<ActuatorItem> mockStatus = new ArrayList(Arrays.asList(
                new ActuatorItem("Light System", "ON"),
                new ActuatorItem("Irrigation System", "OFF"),
                new ActuatorItem("Air conditioner System", "OFF")
        ));
        statusValues.postValue(mockStatus);
    }
}
