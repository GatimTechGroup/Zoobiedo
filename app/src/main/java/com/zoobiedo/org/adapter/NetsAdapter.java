package com.zoobiedo.org.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zoobiedo.org.R;
import com.zoobiedo.org.activity.MatchScheduleActivity;
import com.zoobiedo.org.model.Grounds;

import java.util.List;

/**
 * Created by Venkatesh on 07-09-2016.
 */
    public class NetsAdapter extends RecyclerView.Adapter<NetsAdapter.MyViewHolder> {

    List<Grounds> groundsList;
    Context context;


    public NetsAdapter(Context context,List<Grounds> groundsList)
    {
        this.groundsList = groundsList;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nets_list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.groundName.setText(groundsList.get(position).getName());
        holder.areaName.setText(groundsList.get(position).getArea());
        holder.distance.setText(groundsList.get(position).getDistance());
        holder.rating.setText(groundsList.get(position).getRating());

        if(position == 1) {
            holder.icon.setBackgroundResource(R.drawable.cricketbg);
        }
        else if(position ==2)
        {
            holder.icon.setBackgroundResource(R.drawable.cricketbg);
        }
        else if(position ==3)
        {
            holder.icon.setBackgroundResource(R.drawable.cricketbg);
        }
        else
        {
            holder.icon.setBackgroundResource(R.drawable.cricketbg);
        }

        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(new Intent(context, MatchScheduleActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return groundsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView groundName,areaName,rating,distance;

        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            groundName = (TextView)itemView.findViewById(R.id.groundName);
            areaName = (TextView)itemView.findViewById(R.id.groundArea);
            rating = (TextView)itemView.findViewById(R.id.rating);
            distance = (TextView)itemView.findViewById(R.id.distance);
            icon = (ImageView)itemView.findViewById(R.id.groundIcon);
        }
    }
}
