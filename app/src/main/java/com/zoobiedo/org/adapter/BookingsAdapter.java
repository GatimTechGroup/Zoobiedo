package com.zoobiedo.org.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zoobiedo.org.R;
import com.zoobiedo.org.model.BookingTimeSlots;
import com.zoobiedo.org.utils.AppUtils;

import java.util.ArrayList;

/**
 * Created by Venkatesh on 23-10-2016.
 */
public class BookingsAdapter extends RecyclerView.Adapter<BookingsAdapter.MyViewHolder> {

    ArrayList<BookingTimeSlots> bookingsList;
    Context context;
    TextView txtPrice;

    public BookingsAdapter(Context context,ArrayList<BookingTimeSlots> bookingsList,TextView txtPrice)
    {
        this.context = context;
        this.bookingsList = bookingsList;
        this.txtPrice = txtPrice;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booking_list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BookingsAdapter.MyViewHolder holder, int position) {

        holder.booking.setText(AppUtils.getHour(bookingsList.get(position).getStartTime())+"-"+AppUtils.getHour(bookingsList.get(position).getEndTime()));
        holder.price.setText(String.valueOf(bookingsList.get(position).getSlotPrice()));
        final int index = position;
        holder.booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtPrice.setText(String.valueOf(bookingsList.get(index).getSlotPrice()));
                holder.booking.setBackgroundResource(R.drawable.view_boarder_gray);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookingsList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView price;

        Button booking;

        public MyViewHolder(View itemView) {
            super(itemView);
            price = (TextView)itemView.findViewById(R.id.price);
            booking = (Button)itemView.findViewById(R.id.booking);
        }
    }
}
