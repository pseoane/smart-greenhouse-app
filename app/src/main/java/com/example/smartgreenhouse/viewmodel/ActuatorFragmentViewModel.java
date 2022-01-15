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

import java.util.ArrayList;

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
        /*ArrayList<ActuatorItem> mockStatus = new ArrayList(Arrays.asList(
                new ActuatorItem("Light System", "ON"),
                new ActuatorItem("Irrigation System", "OFF"),
                new ActuatorItem("Air conditioner System", "OFF")
        ));
        statusValues.postValue(mockStatus);*/
        ArrayList<ActuatorItem> actuatorItems = new ArrayList<>();
        Client.getSharedInstance().getIrrigationStatus(
                response ->{
                    Attribute[] attributes = new Gson().fromJson(response.toString(),
                            Attribute[].class);
                    Log.d("Attr", attributes.toString());
                    for(Attribute attribute : attributes){
                        if (attribute.key.equals("statusIrrigation")){
                            actuatorItems.add(
                                    new ActuatorItem(
                                            "Irrigation System",
                                            attribute.value
                                    )
                            );
                        }
                    }
                    statusValues.postValue(actuatorItems);
                },
                error -> {

                }
        );
    }
}
