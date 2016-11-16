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
import com.zoobiedo.org.model.GroundType;
import com.zoobiedo.org.model.Grounds;

import java.util.List;

/**
 * Created by Venkatesh on 07-09-2016.
 */
public class SurfaceAdapter extends RecyclerView.Adapter<SurfaceAdapter.MyViewHolder> {

    List<GroundType> groundsList;
    Context context;


    public SurfaceAdapter(Context context,List<GroundType> groundsList)
    {
        this.groundsList = groundsList;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_ground_types,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.groundName.setText(groundsList.get(position).getGroundName());
        holder.icon.setBackgroundResource(R.drawable.greentick);


    }

    @Override
    public int getItemCount() {
        return groundsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView groundName;

        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            groundName = (TextView)itemView.findViewById(R.id.txtGroundType);
            icon = (ImageView)itemView.findViewById(R.id.imagetick);
        }
    }
}
