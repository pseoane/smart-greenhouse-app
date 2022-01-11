package com.example.smartgreenhouse.view.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.ActuatorItem;

public class MyViewHolderAct extends RecyclerView.ViewHolder {
    // Holds references to individual item views
    Context context;
    TextView aName;
    TextView aStatus;
    ImageView aIcon;
    public int[] images;

    private static final String TAG = "ListOfItems, MyViewHolderAct";

    public MyViewHolderAct(Context ctxt, View itemView) {
        super(itemView);
        context = ctxt;
        aName = itemView.findViewById(R.id.actuatorName);
        aStatus = itemView.findViewById(R.id.currentStatus);
        aIcon = itemView.findViewById(R.id.actuatorIcon);
    }

    public void bindValues(ActuatorItem item, int position) {
        // give values to the elements contained in the item view
        aName.setText(item.getActuatorName());
        aStatus.setText("STATUS: " + item.getCurrentStatus());
        aIcon.setImageResource(position);
    }
}
