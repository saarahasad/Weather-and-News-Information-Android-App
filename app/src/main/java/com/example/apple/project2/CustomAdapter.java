package com.example.apple.project2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;

    public  class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewField;
        TextView textViewEntry;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewField = (TextView) itemView.findViewById(R.id.textViewField);
            this.textViewEntry = (TextView) itemView.findViewById(R.id.textViewEntry);
           this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageViewimg);
        }
    }

    public CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.details_rv, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewField;
        TextView textViewVersion = holder.textViewEntry;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getVersion());
   //     switch (listPosition)
       /* {
            case 0: imageView.setImageResource(R.drawable.lat_icon);
                break;
            case 1:imageView.setImageResource(R.drawable.lat_icon);
                break;
            case 2:imageView.setImageResource(R.drawable.country_icon);
                break;
            case 3:imageView.setImageResource(R.drawable.desc_icon);
                break;

            case 4:imageView.setImageResource(R.drawable.temp_icon);
                break;
            case 5:imageView.setImageResource(R.drawable.hum_icon);
                break;
            case 6:imageView.setImageResource(R.drawable.min_icon);
                break;
            case 7: imageView.setImageResource(R.drawable.max_temp);
            break;
            case 8:imageView.setImageResource(R.drawable.speed_icon);
                break;
            case 9: imageView.setImageResource(R.drawable.city_icon);
            break;
        }*/
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}