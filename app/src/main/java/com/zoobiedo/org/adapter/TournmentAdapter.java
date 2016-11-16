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
import com.zoobiedo.org.model.Tournments;

import java.util.List;

/**
 * Created by Venkatesh on 07-09-2016.
 */
public class TournmentAdapter extends RecyclerView.Adapter<TournmentAdapter.MyViewHolder> {

    List<Tournments> tournmentsList;
    Context context;


    public TournmentAdapter(Context context,List<Tournments> tournmentsList)
    {
        this.tournmentsList = tournmentsList;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tournments_list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tournmentName.setText(tournmentsList.get(position).getName());
        holder.date.setText(tournmentsList.get(position).getDate());
        holder.price.setText(tournmentsList.get(position).getPrice());

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
        return tournmentsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tournmentName,date,price;

        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            tournmentName = (TextView)itemView.findViewById(R.id.tournmentName);
            date = (TextView)itemView.findViewById(R.id.date);
            price = (TextView)itemView.findViewById(R.id.price);
            icon = (ImageView)itemView.findViewById(R.id.tournmentIcon);
        }
    }
}
