package com.example.smartgreenhouse.view.viewholder.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.ActuatorItem;
import com.example.smartgreenhouse.view.viewholder.MyViewHolderAct;

import java.util.ArrayList;
import java.util.HashMap;

public class ActuatorsAdapter extends RecyclerView.Adapter<MyViewHolderAct> {
    public ArrayList<ActuatorItem> items;
    private Context context;
    public HashMap<String, Integer> images;

    public ActuatorsAdapter(
            Context ctxt,
            ArrayList<ActuatorItem> listofitems,
            HashMap<String, Integer> listofimages
    ) {
        super();
        context = ctxt;
        items = listofitems;
        images = listofimages;
    }

    @Override
    public MyViewHolderAct onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method has to actually inflate the item view and return the view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.actuator_items, parent, false);
        int height = parent.getMeasuredHeight() / 6;
        v.setMinimumHeight(height);
        return new MyViewHolderAct(context, v);
    }

    @Override
    public void onBindViewHolder(MyViewHolderAct holder, int position) {
        // this method actually gives values to the elements of the view holder
        // (values corresponding to the item in 'position')
        final ActuatorItem item = items.get(position);
        holder.bindValues(item, images.get(item.getActuatorName().toUpperCase()));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
