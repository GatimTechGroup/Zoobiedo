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
import com.zoobiedo.org.activity.OrganizersActiivty;
import com.zoobiedo.org.model.Grounds;
import com.zoobiedo.org.model.Organizers;

import java.util.List;

/**
 * Created by Venkatesh on 07-09-2016.
 */
public class OrganizersAdapter extends RecyclerView.Adapter<OrganizersAdapter.MyViewHolder> {

    List<Organizers> organizersList;
    Context context;
    View itemView;

    public OrganizersAdapter(Context context,List<Organizers> organizersList)
    {
        this.organizersList = organizersList;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

         itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.organiser_list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.orgName.setText(organizersList.get(position).getName());
        holder.areaName.setText(organizersList.get(position).getArea());
        holder.member.setText(organizersList.get(position).getMember());
        holder.rating.setText(organizersList.get(position).getRating());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(new Intent(context, OrganizersActiivty.class));
            }
        });
       /* if(position == 1) {
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
        }*/

    }

    @Override
    public int getItemCount() {
        return organizersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView orgName,areaName,rating,member;

        ImageView icon,starIcon,memberIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            orgName = (TextView)itemView.findViewById(R.id.name);
            areaName = (TextView)itemView.findViewById(R.id.area);
            rating = (TextView)itemView.findViewById(R.id.rating);
            member = (TextView)itemView.findViewById(R.id.member);
            icon = (ImageView)itemView.findViewById(R.id.groundIcon);
            starIcon = (ImageView)itemView.findViewById(R.id.star);
            memberIcon = (ImageView)itemView.findViewById(R.id.membertick);
        }
    }
}
