package com.example.smartgreenhouse.view.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.SensorItem;
import com.example.smartgreenhouse.view.viewholder.adapters.SensorsAdapter;

public class MyViewHolder extends RecyclerView.ViewHolder {

    // Holds references to individual item views
    Context context;
    TextView sName;
    TextView sValue;
    ImageView sIcon;
    public int[] images;

    private static final String TAG = "ListOfItems, MyViewHolder";

    public MyViewHolder(Context ctxt, View itemView) {
        super(itemView);
        context = ctxt;
        sName = itemView.findViewById(R.id.sensorName);
        sValue = itemView.findViewById(R.id.currentValue);
        sIcon = itemView.findViewById(R.id.sensorIcon);
    }

     public void bindValues(SensorItem item, int position) {
        // give values to the elements contained in the item view
        sName.setText(item.getSensorName());
        sValue.setText(item.getCurrentValue());
        sIcon.setImageResource(position);
    }



}
