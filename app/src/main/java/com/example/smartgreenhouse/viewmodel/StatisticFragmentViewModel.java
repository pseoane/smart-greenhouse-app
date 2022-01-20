package com.example.smartgreenhouse.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.smartgreenhouse.model.Client;
import com.example.smartgreenhouse.model.StatisticItem;
import com.example.smartgreenhouse.utils.Triple;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class StatisticFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<StatisticItem>> values;
    private ArrayList<Triple> meanValues = new ArrayList(Arrays.asList(
            new Triple("avgTemp", "Temperature Mean", "ºC"),
            new Triple("avgHum", "Humidity Mean", "%"),
            new Triple("avgLight", "Light Mean", "%"),
            new Triple("avgpH", "pH Mean", ""),
            new Triple("avgSm", "Soil Moisture Mean", "%")
    ));
    private ArrayList<String> keys = new ArrayList<>();

    public StatisticFragmentViewModel(@NonNull Application application) {
        super(application);
        for (Triple meanValue : meanValues) {
            keys.add(meanValue.getFirst());
        }
        refreshValues();
    }

    public MutableLiveData<ArrayList<StatisticItem>> getValues() {
        if (values == null) {
            values = new MutableLiveData<>();
        }
        return values;
    }

    public void refreshValues(){
        ArrayList<StatisticItem> statistics = new ArrayList<>();
        Client.getSharedInstance().getSensorsValues(
                keys,
                response -> {
                    try {
                        for (Triple triple : meanValues) {
                            //JSONArray parameter = response.getJSONArray(triple.getFirst());
                            for (int i = 0; i< response.length(); i++) {

                                //JSONObject jsonObject = parameter.getJSONObject(i);
                                // triple.getThird() are the units (%, ºC, etc)
                                //String value = jsonObject.getString(triple.getFirst()) + triple.getThird();
                                String value = response.get(triple.getFirst()) + triple.getThird();
                                statistics.add(new StatisticItem(triple.getSecond(), value));
                            }
                        }
                        values.postValue(statistics);
                        Log.d("mean", statistics.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    ArrayList<StatisticItem> errorSituation = new ArrayList(Arrays.asList(
                            new StatisticItem(
                                    "WARNING",
                                    "It was not possible to access the values")
                    ));
                    values.postValue(errorSituation);
                }
        );
    }
}
