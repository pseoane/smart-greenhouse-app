package com.example.smartgreenhouse.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.SensorItem;
import com.example.smartgreenhouse.view.viewholder.MyviewHolder;

import java.util.ArrayList;

public class SensorsAdapter extends RecyclerView.Adapter<MyviewHolder> {
    public ArrayList<SensorItem> items;
    private Context context;

    public SensorsAdapter(Context ctxt, ArrayList<SensorItem> listofitems) {
        super();
        context = ctxt;
        items = listofitems;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method has to actually inflate the item view and return the view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sensor_items, parent, false);
        return new MyviewHolder(context, v);
    }


    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
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
