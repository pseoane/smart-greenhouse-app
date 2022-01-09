package com.example.smartgreenhouse.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smartgreenhouse.model.Auth;
import com.example.smartgreenhouse.model.Client;
import com.example.smartgreenhouse.model.SensorItem;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    /*public void refreshValues() {
        // Fake values
        ArrayList<SensorItem> mockValues = new ArrayList(Arrays.asList(
                new SensorItem("temperature", "25ºC"),
                new SensorItem("light", "70%"),
                new SensorItem("soilMoisture", "58%")
        ));
        values.postValue(mockValues);
    }*/

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
                    ArrayList<SensorItem> messageError = new ArrayList<>();
                    String messageName = "errorMessage";
                    String messageValue = response.toString();
                    messageError.add(new SensorItem(messageName, messageValue));
                    values.postValue(messageError);

                    /*try {
                        ArrayList<SensorItem> sensors = new ArrayList<>();
                        JSONArray jsonArray = response.getJSONArray("currentValueHum");
                        int size = jsonArray.length();
                        String sensorName = "Humidity";
                        for(int i=0; i<size; i++ ){
                            JSONObject jsonObject = new JSONObject(response.get(String.valueOf(i)).toString());
                            String sensorValue = jsonObject.getString("value");
                            sensors.add(new SensorItem(sensorName, sensorValue));
                            values.postValue(sensors);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }*/
                },
                error -> {
                    ArrayList<SensorItem> mockValues = new ArrayList(Arrays.asList(
                            new SensorItem("temperature", "25ºC"),
                            new SensorItem("light", "70%"),
                            new SensorItem("soilMoisture", "58%")
                    ));
                    values.postValue(mockValues);
                }
        );
    }

}
