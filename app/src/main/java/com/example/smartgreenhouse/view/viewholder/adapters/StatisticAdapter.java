package com.example.smartgreenhouse.view.viewholder.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.StatisticItem;
import com.example.smartgreenhouse.view.viewholder.MyViewHolderStat;

import java.util.ArrayList;

public class StatisticAdapter extends RecyclerView.Adapter<MyViewHolderStat> {
    public ArrayList<StatisticItem> items;
    private Context context;

    public StatisticAdapter(Context ctxt, ArrayList<StatisticItem> listofitems) {
        super();
        context = ctxt;
        items = listofitems;
    }
    @Override
    public MyViewHolderStat onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method has to actually inflate the item view and return the view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.statistic_items, parent, false);
        //int height = parent.getMeasuredHeight() / 4;
        //v.setMinimumHeight(height);
        return new MyViewHolderStat(context, v);
    }


    @Override
    public void onBindViewHolder(MyViewHolderStat holder, int position) {
        // this method actually gives values to the elements of the view holder
        // (values corresponding to the item in 'position')
        final StatisticItem item = items.get(position);
        holder.bindValues(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
