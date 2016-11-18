package com.zoobiedo.org.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zoobiedo.org.R;
import com.zoobiedo.org.activity.MatchScheduleActivity;
import com.zoobiedo.org.model.Facilities;
import com.zoobiedo.org.model.FacilitySlots;
import com.zoobiedo.org.model.SubFacilities;
import com.zoobiedo.org.utils.AppUtils;
import com.zoobiedo.org.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Venkatesh on 07-09-2016.
 */
public class GroundsAdapter extends RecyclerView.Adapter<GroundsAdapter.MyViewHolder> {

    ArrayList<FacilitySlots> mFailitySlotsList =  new ArrayList<>();
    ArrayList<SubFacilities> mSubFacilitiesList = new ArrayList<>();
    Set<SubFacilities> mClearSet = new HashSet<>();
    ArrayList<Facilities> mFacilitiesList = new ArrayList<>();
    HashMap<String,ArrayList<Facilities>> facilitiesHashMap = new HashMap<>();

    public transient Activity context;
    String type;

    public GroundsAdapter(Activity context,ArrayList<FacilitySlots> mFailitySlotsList,String type)
    {
        this.mFailitySlotsList = mFailitySlotsList;
        this.context = context;
        this.type  = type;
        facilitiesHashMap = AppUtils.getFacilityMap(mFailitySlotsList);
        mFacilitiesList = AppUtils.getFacilities(mFailitySlotsList);
        mSubFacilitiesList = AppUtils.getSubFacilities(mFacilitiesList);
        mClearSet.addAll(mSubFacilitiesList);
        mSubFacilitiesList.clear();
        mSubFacilitiesList.addAll(mClearSet);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nets_list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.groundName.setText(mSubFacilitiesList.get(position).getSubFacilityName());
        holder.areaName.setText(mSubFacilitiesList.get(position).getAddressLine3());
        holder.distance.setText("" + mSubFacilitiesList.get(position).getDistance() + "" + "Km");
        holder.rating.setText(String.valueOf(mSubFacilitiesList.get(position).getSubFacilityId()));

        if(type.equalsIgnoreCase(Constants.LIST_GROUNDS_CRIC)) {
            Glide.with(context)
                    .load(mSubFacilitiesList.get(position).getImage1URL())
                    .placeholder(R.drawable.cricketbg)
                    .centerCrop()
                    .into(holder.icon);
        }
        else if(type.equalsIgnoreCase(Constants.LIST_GROUNDS_BAD))
        {
            Glide.with(context)
                    .load(mSubFacilitiesList.get(position).getImage1URL())
                    .placeholder(R.drawable.badmintonbg)
                    .centerCrop()
                    .into(holder.icon);
        }

        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,MatchScheduleActivity.class);
                if(type.equalsIgnoreCase(Constants.LIST_GROUNDS_CRIC)) {

                    intent.putExtra(context.getResources().getString(R.string.extras_matchtype_cricket), "crick");
                    intent.putExtra(context.getResources().getString(R.string.extras_slots), mFailitySlotsList);
                    intent.putExtra(context.getResources().getString(R.string.extras_sub_facility_id), mSubFacilitiesList.get(position).getSubFacilityId());
                  //  intent.putExtras(b);
                }else
                {
                    intent.putExtra(context.getResources().getString(R.string.extras_matchtype_bad), "batminton");
                    intent.putExtra(context.getResources().getString(R.string.extras_slots), mFailitySlotsList);
                    intent.putExtra(context.getResources().getString(R.string.extras_sub_facility_id), mSubFacilitiesList.get(position).getSubFacilityId());
                }

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSubFacilitiesList.size();
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
