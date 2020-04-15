package com.jayant.sudo.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jayant.sudo.Modal.Data;
import com.jayant.sudo.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private Context context;
    private List<Data> dataList;

    public DataAdapter(Context context,List<Data> dataList)
    {
        this.context=context;
        this.dataList=dataList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate((R.layout.each_row),parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Data data=dataList.get(position);
        holder.city.setText("City: "+data.getLocation());
        holder.confirm_indians.setText("Confirms Indians: "+data.getConfirm_cases_indian());
        holder.confirm_foreign.setText("Confirms Foreign: "+data.getConfirm_cases_foreign());
        holder.deaths.setText("Deaths: "+data.getDeaths());
        holder.discharge.setText("Discharge: "+data.getDischarge());
        holder.total_confirms.setText("Confirm Cases: "+data.getTotal_confirm());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{
      private TextView city,confirm_indians,confirm_foreign,deaths,discharge,total_confirms;
        public DataViewHolder(View itemview)
        {
            super(itemview);
            city=itemview.findViewById(R.id.city);
            confirm_indians=itemview.findViewById(R.id.india);
            confirm_foreign=itemview.findViewById(R.id.foreign);
            deaths=itemview.findViewById(R.id.city_deaths);
            discharge=itemview.findViewById(R.id.city_discharge);
            total_confirms=itemview.findViewById(R.id.total_confirm);
        }

    }
}
