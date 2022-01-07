package com.example.smartgreenhouse.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.SensorItem;
import com.example.smartgreenhouse.view.viewholder.MyViewHolder;

import java.util.ArrayList;

public class SensorsAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public ArrayList<SensorItem> items;
    private Context context;

    public SensorsAdapter(Context ctxt, ArrayList<SensorItem> listofitems) {
        super();
        context = ctxt;
        items = listofitems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method has to actually inflate the item view and return the view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sensor_items, parent, false);
        return new MyViewHolder(context, v);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // this method actually gives values to the elements of the view holder
        // (values corresponding to the item in 'position')
        final SensorItem item = items.get(position);
        holder.bindValues(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }




}
