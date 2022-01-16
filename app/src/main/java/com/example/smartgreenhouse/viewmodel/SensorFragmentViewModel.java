package com.example.smartgreenhouse.viewmodel;

import android.app.Application;
import android.graphics.Color;
import android.util.Log;
import android.util.Pair;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.smartgreenhouse.model.Client;
import com.example.smartgreenhouse.model.SensorItem;
import com.example.smartgreenhouse.utils.Triple;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class SensorFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<SensorItem>> values;
    private ArrayList<Triple> sensorNames = new ArrayList(Arrays.asList(
            new Triple("currentValueHum", "Humidity", "%"),
            new Triple("currentValueL", "Light", "%"),
            new Triple("currentValuepH", "pH", ""),
            new Triple("currentValueSM", "Soil Moisture", "%"),
            new Triple("currentValueTemp", "Temperature", "ºC")
    ));
    private ArrayList<String> keys = new ArrayList<>();

    public SensorFragmentViewModel(@NonNull Application application) {
        super(application);
        for (Triple sensorName : sensorNames) {
            keys.add(sensorName.getFirst());
        }
        refreshValues();
    }

    public MutableLiveData<ArrayList<SensorItem>> getValues() {
        if (values == null) {
            values = new MutableLiveData<>();
        }
        return values;
    }

    private void getAlarmsStatus(ArrayList<SensorItem> sensors){
        Client.getSharedInstance().getAlarms(
                response -> {
                    try {
                        ArrayList<String> alarmsReceived = new ArrayList<>();
                        JSONArray data = response.getJSONArray("data");
                        for(int i=0; i<data.length(); i++ ){
                            JSONObject jsonObject = data.getJSONObject(i);
                            String alarm = jsonObject.getString("type");
                            alarmsReceived.add(alarm);
                        }
                        for (SensorItem sensorItem : sensors) {
                            for (String alarm : alarmsReceived) {
                                if (alarm.contains(sensorItem.getSensorName().toUpperCase())) {
                                    sensorItem.setAlarmStatus("ON");
                                }
                            }
                        }
                        values.postValue(sensors);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    ArrayList<String> alarmsReceived = new ArrayList<String>();
                    alarmsReceived.add("OK");
                }
        );
    }

    public void refreshValues(){
        ArrayList<SensorItem> sensors = new ArrayList<>();
        Client.getSharedInstance().getSensorsValues(
                keys,
                response -> {
                    try {
                        String tempAlarmStatus = "OFF";
                        for (Triple triple : sensorNames) {
                            JSONArray parameter = response.getJSONArray(triple.getFirst());
                            for (int i = 0; i< parameter.length(); i++) {
                                JSONObject jsonObject = parameter.getJSONObject(i);
                                // triple.getThird() are the units (%, ºC, etc)
                                String value = jsonObject.getString("value") + triple.getThird();
                                sensors.add(new SensorItem(triple.getSecond(), value, tempAlarmStatus));
                            }
                        }
                        // We don't post any values to the views until alarms are ready
                        getAlarmsStatus(sensors);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    ArrayList<SensorItem> errorSituation = new ArrayList(Arrays.asList(
                            new SensorItem("WARNING", "It was not possible to access the values", "")
                    ));
                    values.postValue(errorSituation);
                }
        );
    }



}
