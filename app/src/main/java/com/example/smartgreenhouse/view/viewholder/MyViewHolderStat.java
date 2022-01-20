package com.example.smartgreenhouse.view.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.SensorItem;
import com.example.smartgreenhouse.model.StatisticItem;

public class MyViewHolderStat extends RecyclerView.ViewHolder {

    // Holds references to individual item views
    Context context;
    TextView sName;
    TextView sMean;

    public MyViewHolderStat(Context ctxt, View itemView) {
        super(itemView);
        context = ctxt;
        sName = itemView.findViewById(R.id.parameterName);
        sMean = itemView.findViewById(R.id.parameterMean);
    }

    public void bindValues(StatisticItem item) {
        // give values to the elements contained in the item view
        sName.setText(item.getParameterName());
        sMean.setText(item.getParameterMean());
    }
}
