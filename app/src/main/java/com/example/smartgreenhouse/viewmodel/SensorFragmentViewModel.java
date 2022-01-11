package com.example.smartgreenhouse.viewmodel;

import android.app.Application;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.smartgreenhouse.model.Client;
import com.example.smartgreenhouse.model.SensorItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class SensorFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<SensorItem>> values;
    private MutableLiveData<ArrayList<String>> alarmsValues;

    public SensorFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<ArrayList<SensorItem>> getValues() {
        if (values == null) {
            values = new MutableLiveData<>();
        }
        return values;
    }

    public MutableLiveData<ArrayList<String>> getAlarms() {
        if (alarmsValues == null) {
            alarmsValues = new MutableLiveData<>();
        }
        return alarmsValues;
    }

    public void refreshValues(){
        ArrayList<String> keys = new ArrayList(Arrays.asList(
                "currentValueHum",
                "currentValueL",
                "currentValuepH",
                "currentValueSM",
                "currentValueTemp"
        ));
        Client.getSharedInstance().getSensorsValues(
                keys,
                response -> {
                    try {
                        ArrayList<SensorItem> sensors = new ArrayList<>();
                        ArrayList<String> sensorsName = new ArrayList(Arrays.asList( "Humidity", "Light", "pH", "Soil Moisture", "Temperature"));
                        JSONArray humParameter = response.getJSONArray("currentValueHum");
                        for(int i=0; i<humParameter.length(); i++ ){
                            JSONObject jsonObject = humParameter.getJSONObject(i);
                            String sensorValue = jsonObject.getString("value") + " %";
                            sensors.add(new SensorItem(sensorsName.get(0), sensorValue));

                        }
                        JSONArray lightParameter = response.getJSONArray("currentValueL");
                        for(int i=0; i<lightParameter.length(); i++ ){
                            JSONObject jsonObject = lightParameter.getJSONObject(i);
                            String sensorValue = jsonObject.getString("value") + " %";
                            sensors.add(new SensorItem(sensorsName.get(1), sensorValue));

                        }
                        JSONArray pHParameter = response.getJSONArray("currentValuepH");
                        for(int i=0; i<pHParameter.length(); i++ ){
                            JSONObject jsonObject = pHParameter.getJSONObject(i);
                            String sensorValue = jsonObject.getString("value");
                            sensors.add(new SensorItem(sensorsName.get(2), sensorValue));

                        }
                        JSONArray smParameter = response.getJSONArray("currentValueSM");
                        for(int i=0; i<smParameter.length(); i++ ){
                            JSONObject jsonObject = smParameter.getJSONObject(i);
                            String sensorValue = jsonObject.getString("value") + " %";
                            sensors.add(new SensorItem(sensorsName.get(3), sensorValue));

                        }
                        JSONArray tempParameter = response.getJSONArray("currentValueTemp");
                        for(int i=0; i<tempParameter.length(); i++ ){
                            JSONObject jsonObject = tempParameter.getJSONObject(i);
                            String sensorValue = jsonObject.getString("value") + " ºC";
                            sensors.add(new SensorItem(sensorsName.get(4), sensorValue));

                        }
                        values.postValue(sensors);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    ArrayList<SensorItem> errorSituation = new ArrayList(Arrays.asList(
                            new SensorItem("WARNING", "It was not possible to access the values")
                    ));
                    values.postValue(errorSituation);
                }
        );
    }

    public void getAlarmsStatus(){
        Client.getSharedInstance().getAlarms(
            response -> {
                try {
                    ArrayList<String> alarmsReceived = new ArrayList<String>();
                    JSONArray data = response.getJSONArray("data");
                    for(int i=0; i<data.length(); i++ ){
                        JSONObject jsonObject = data.getJSONObject(i);
                        String alarm = jsonObject.getString("type");
                        alarmsReceived.add(alarm);
                    }

                    alarmsValues.postValue(alarmsReceived);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            },
            error -> {
                ArrayList<String> alarmsReceived = new ArrayList<String>();
                alarmsReceived.add("OK");
                alarmsValues.postValue(alarmsReceived);
            }
        );
    }



}
