package com.example.smartgreenhouse.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.smartgreenhouse.model.ActuatorItem;
import com.example.smartgreenhouse.model.Attribute;
import com.example.smartgreenhouse.model.Client;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActuatorFragmentViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<ActuatorItem>> statusValues;

    public ActuatorFragmentViewModel(@NonNull Application application) {
        super(application);
        refreshStatusValues();
    }

    public MutableLiveData<ArrayList<ActuatorItem>> getValues() {
        if (statusValues == null) {
            statusValues = new MutableLiveData<>();
        }
        return statusValues;
    }

    public void refreshStatusValues(){
        Client.getSharedInstance().getIrrigationStatus(
                response -> {
                    try {
                        ArrayList<ActuatorItem> actuatorItems = new ArrayList<>();
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject actuator = response.getJSONObject(i);
                            String value = actuator.get("value").toString();
                            if (isBoolean(value)) {
                                actuatorItems.add(
                                        new ActuatorItem(
                                                "Smart Irrigation System",
                                                actuator.getBoolean("value")
                                        )
                                );
                                break;
                            }
                            refreshLight(actuatorItems);
                        }
                    } catch (Exception e){
                        Log.d("Error", e.getMessage());
                    }
                },
                error -> {
                    Log.d("Error", error.toString());
                }
        );
    }

    private boolean isBoolean(String str) {
        return str.equals("true") || str.equals("false");
    }

    private void refreshLight(ArrayList<ActuatorItem> previousActuatorValues) {
        Client.getSharedInstance().getLightStatus(
                response -> {
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject actuator = response.getJSONObject(i);
                            String value = actuator.get("value").toString();
                            if (isBoolean(value)) {
                                previousActuatorValues.add(
                                        new ActuatorItem(
                                                "Smart Light System",
                                                actuator.getBoolean("value")
                                        )
                                );
                                break;
                            }
                        }
                        getValues().postValue(previousActuatorValues);
                    } catch (Exception e){
                        Log.d("Error", e.getMessage());
                    }
                },
                error -> {
                    Log.d("Error", error.toString());
                }
        );
    }

}
