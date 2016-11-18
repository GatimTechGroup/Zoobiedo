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
import com.zoobiedo.org.utils.Constants;

import java.util.List;

/**
 * Created by Venkatesh on 07-09-2016.
 */
public class FacilitiesAdapter extends RecyclerView.Adapter<FacilitiesAdapter.MyViewHolder> {

    List<GroundType> groundsList;
    Context context;
    String type;


    public FacilitiesAdapter(Context context,List<GroundType> groundsList,String type)
    {
        this.groundsList = groundsList;
        this.context = context;
        this.type = type;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_options,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //holder.groundName.setText(groundsList.get(position).getName());

        if(type.equalsIgnoreCase(Constants.LIST_TYPE_FACILITIES))
        {
            holder.name.setVisibility(View.GONE);
            if (groundsList.get(position).getGroundName().equalsIgnoreCase(Constants.FACILITY_CAFETARIA)) {
                holder.icon.setBackgroundResource(R.drawable.facilityfood);
            } else if (groundsList.get(position).getGroundName().equalsIgnoreCase(Constants.FACILITY_RESTROOM)) {
                holder.icon.setBackgroundResource(R.drawable.facilitykit);
            } else if (groundsList.get(position).getGroundName().equalsIgnoreCase(Constants.FACILITY_FIRST_AID)) {
                holder.icon.setBackgroundResource(R.drawable.facilityfirstaid);
            } else if (groundsList.get(position).getGroundName().equalsIgnoreCase(Constants.FACILITY_AMBULANCE)) {
               // holder.icon.setBackgroundResource(R.drawable.facilitykit);
            } else if (groundsList.get(position).getGroundName().equalsIgnoreCase(Constants.FACILITY_BALL_PURCHASE)) {
                holder.icon.setBackgroundResource(R.drawable.facilityfirstaid);
            } else if (groundsList.get(position).getGroundName().equalsIgnoreCase(Constants.FACILITY_FLOOD_LIGHT)) {
                //holder.icon.setBackgroundResource(R.drawable.facilityfirstaid);
            } else if (groundsList.get(position).getGroundName().equalsIgnoreCase(Constants.FACILITY_SHOE)) {
               // holder.icon.setBackgroundResource(R.drawable.facilityfirstaid);
            } else if (groundsList.get(position).getGroundName().equalsIgnoreCase(Constants.FACILITY_SHOWER)) {
                //holder.icon.setBackgroundResource(R.drawable.facilityfirstaid);
            }
        }
        else if(type.equalsIgnoreCase(Constants.LIST_TYPE_OPTIONS))
        {
            if(position == 0) {
                holder.icon.setBackgroundResource(R.drawable.navigation);
                holder.name.setText(groundsList.get(position).getGroundName());
            }
            else if(position == 1)
            {
                holder.icon.setBackgroundResource(R.drawable.gallery);
                holder.name.setText(groundsList.get(position).getGroundName());
            }
            else if(position ==2)
            {
                holder.icon.setBackgroundResource(R.drawable.videoicon);
                holder.name.setText(groundsList.get(position).getGroundName());
            }
        }

    }

    @Override
    public int getItemCount() {
        return groundsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView icon;
        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView)itemView.findViewById(R.id.imageIcon);
            name = (TextView) itemView.findViewById(R.id.txtGroundType);
        }
    }
}
