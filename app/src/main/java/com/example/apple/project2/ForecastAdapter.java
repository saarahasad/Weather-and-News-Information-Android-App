package com.example.apple.project2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.MyViewHolder> {

    private ArrayList<ForecastModel> dataSet;
    Context context;

    public  class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewMin;
        TextView textViewMax;
        TextView textViewDesc;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName1);
            this.textViewMin = (TextView) itemView.findViewById(R.id.textViewMin1);
            this.textViewMax = (TextView) itemView.findViewById(R.id.textViewMax1);
            this.textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            this.imageViewIcon= (ImageView) itemView.findViewById(R.id.imageViewIcon);

            //  this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public ForecastAdapter(ArrayList<ForecastModel> data,Context context) {
        this.context=context;
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_rv, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewMin = holder.textViewMin;
        TextView textViewMax = holder.textViewMax;
        TextView textViewDesc = holder.textViewDesc;
        ImageView imageViewIcon=holder.imageViewIcon;


        //    ImageView imageView = holder.imageViewIcon;
        textViewName.setText(dataSet.get(listPosition).getName());
        textViewMin.setText(dataSet.get(listPosition).getMin()+"°C");
        String TAG = "MyActivity";
        Log.d(TAG,"NAME: "+ dataSet.get(listPosition).getName());
        textViewMax.setText(dataSet.get(listPosition).getMax()+"°C");
        textViewDesc.setText(dataSet.get(listPosition).getDesc());
        String ic=dataSet.get(listPosition).getICon();
        Log.d(TAG,"Image res:"+ic);


        if("w01d".equals(ic)) {
            imageViewIcon.setImageResource(R.drawable.w01d);
            Log.d(TAG,"Image res:"+ic);

        }

        if("w10d".equals(ic)) {
            imageViewIcon.setImageResource(R.drawable.w10d);
            Log.d(TAG,"Image res:"+ic);

        }
        if("w02d".equals(ic)) {
            imageViewIcon.setImageResource(R.drawable.w02d);
            Log.d(TAG,"Image res:"+ic);
        }
        if("w02n".equals(ic)) {
            imageViewIcon.setImageResource(R.drawable.w02n);
            Log.d(TAG,"Image res:"+ic);
        }
        if("w03n".equals(ic)) {
            imageViewIcon.setImageResource(R.drawable.w03n);
            Log.d(TAG,"Image res:"+ic);
        }

        if("w03n".equals(ic)) {
            imageViewIcon.setImageResource(R.drawable.w03n);
            Log.d(TAG,"Image res:"+ic);
        }
        if("w04n".equals(ic)) {
            imageViewIcon.setImageResource(R.drawable.w04n);
            Log.d(TAG,"Image res:"+ic);
        }
        if("w04d".equals(ic)) {
            imageViewIcon.setImageResource(R.drawable.w04d);
            Log.d(TAG,"Image res:"+ic);
        }




        //    imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}