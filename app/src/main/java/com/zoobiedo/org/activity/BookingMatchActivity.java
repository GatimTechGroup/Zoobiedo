package com.zoobiedo.org.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zoobiedo.org.R;
import com.zoobiedo.org.adapter.BookingsAdapter;
import com.zoobiedo.org.model.BookingTimeSlots;
import com.zoobiedo.org.model.FacilitySlots;
import com.zoobiedo.org.model.SubFacilities;
import com.zoobiedo.org.utils.AppUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;


public class BookingMatchActivity extends AppCompatActivity {

    ArrayList<SubFacilities> mSubFacilitiesList = new ArrayList<>();
    ArrayList<FacilitySlots> mFacilitiSlotsList = new ArrayList<>();
    private SubFacilities mSubFacility = new SubFacilities();
    private ArrayList<BookingTimeSlots> mbookingSlotsList = new ArrayList<>();
    Button individual;
    Button singleSlot;
    Button fullSlot;
    TextView groundName;
    TextView groundArea;
    TextView selectedPrice;
    RecyclerView mBookingList;
    BookingsAdapter mAdatper;
    private LinearLayout selectDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_match);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Booking");
        mFacilitiSlotsList = getIntent().getParcelableArrayListExtra(getString(R.string.extras_slots));
        mSubFacilitiesList = AppUtils.getSubFacilities(AppUtils.getFacilities(mFacilitiSlotsList));
        mSubFacility = AppUtils.getSubFacilityFromId(mSubFacilitiesList, getIntent().getIntExtra(getString(R.string.extras_sub_facility_id), 0));
        mBookingList = (RecyclerView)findViewById(R.id.myListBookings);
        selectDate = (LinearLayout) findViewById(R.id.dateBooking);

        individual= (Button)findViewById(R.id.slotIndi);
        singleSlot= (Button)findViewById(R.id.slotSingle);
        fullSlot = (Button)findViewById(R.id.fullSlot);


        groundName = (TextView)findViewById(R.id.courtName);
        groundArea = (TextView)findViewById(R.id.courtArea);
        selectedPrice = (TextView)findViewById(R.id.selectedPrice);



        groundName.setText(mSubFacility.getSubFacilityName());
        groundArea.setText(mSubFacility.getAddressLine3());

        RecyclerView.LayoutManager mLayoutManagerVer = new LinearLayoutManager(BookingMatchActivity.this,LinearLayoutManager.VERTICAL, false);
        mBookingList.setLayoutManager(mLayoutManagerVer);
        mBookingList.setItemAnimator(new DefaultItemAnimator());

        if(mSubFacility.getFacilitycalendars() == null)
        {
            return;
        }
        mbookingSlotsList = mSubFacility.getFacilitycalendars().get(0).getBookingtimeslots();

        mAdatper = new BookingsAdapter(this,mbookingSlotsList,selectedPrice);
        mBookingList.setAdapter(mAdatper);

        initDateDialog(selectDate);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void submit(View v) {

        switch (v.getId())
        {
            case R.id.slotIndi:
                break;
            case R.id.slotSingle:
                break;
            case R.id.fullSlot:
                break;
        }

    }
    private void initDateDialog(LinearLayout dateCrick) {

        final ImageView preDate =(ImageView)dateCrick.findViewById(R.id.preDate);
        final ImageView nextDate =(ImageView)dateCrick.findViewById(R.id.nextDate);
        final ImageView cal =(ImageView)dateCrick.findViewById(R.id.calender);
        final TextView date =(TextView)dateCrick.findViewById(R.id.date);

        final Calendar myCalender = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppUtils.createDatepicker(BookingMatchActivity.this, date, preDate, nextDate, myCalender);
            }
        });

    }
}
