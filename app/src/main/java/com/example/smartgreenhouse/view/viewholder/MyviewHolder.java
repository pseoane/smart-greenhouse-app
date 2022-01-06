package com.example.smartgreenhouse.view.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.SensorItems;

public class MyviewHolder extends RecyclerView.ViewHolder {

    // Holds references to individual item views
    Context context;
    TextView sName;
    TextView sValue;

    private static final String TAG = "ListOfItems, MyViewHolder";

    public MyviewHolder(Context ctxt, View itemView) {
        super(itemView);
        context = ctxt;
        sName = itemView.findViewById(R.id.sensorName);
        sValue = itemView.findViewById(R.id.currentValue);

    }

     public void bindValues(SensorItems item) {
        // give values to the elements contained in the item view
        sName.setText(item.getSensorName());
        sValue.setText(item.getCurrentValue());

    }



}
