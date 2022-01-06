package com.example.smartgreenhouse;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

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

    void bindValues(SensorItems item) {
        // give values to the elements contained in the item view
        sName.setText(item.getSensorName());
        sValue.setText(item.getCurrentValue());

    }



}
