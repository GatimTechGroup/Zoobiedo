package com.zoobiedo.org.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zoobiedo.org.R;
import com.zoobiedo.org.adapter.FacilitiesAdapter;
import com.zoobiedo.org.adapter.SurfaceAdapter;
import com.zoobiedo.org.model.Facilities;
import com.zoobiedo.org.model.FacilitySlots;
import com.zoobiedo.org.model.GroundType;
import com.zoobiedo.org.model.SubFacilities;
import com.zoobiedo.org.utils.AppUtils;
import com.zoobiedo.org.utils.Constants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

public class MatchScheduleActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private TextView[] dots;
    private int[] layouts;
    LinearLayout dotsLayout,layoutCrikcet,layoutBadminton;
    private MyViewPagerAdapter myViewPagerAdapter;
    Button btnBook;
    private SurfaceAdapter mGroundTypeAdapter;
    private FacilitiesAdapter mFacilitiesAdapter;
    private LinearLayout dateCrick,dateBat;
    private RelativeLayout startTime,endTime;
    ArrayList<SubFacilities> mSubFacilitiesList = new ArrayList<>();
    ArrayList<FacilitySlots> mFacilitiSlotsList = new ArrayList<>();
    ArrayList<Facilities> mFacilitiesList = new ArrayList<>();
    HashMap<String,ArrayList<Facilities>> facilitiesHashMap = new HashMap<>();
    private SubFacilities mSubFacilities = new SubFacilities();
    ArrayList<String> mList = new ArrayList<>();
    private TextView groundName,groundArea,coutName,coutArea;
    RecyclerView myListFacilitiesCkt,myListOptions,myListFacilitiesBad,myListCrikcetGroundTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_schedule);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        layoutCrikcet = (LinearLayout) findViewById(R.id.layoutCricket);
        layoutBadminton = (LinearLayout) findViewById(R.id.layoutBadminton);
        dateCrick = (LinearLayout) findViewById(R.id.dateCricket);
        dateBat = (LinearLayout) findViewById(R.id.dateBad);
        myListFacilitiesCkt = (RecyclerView)findViewById(R.id.myListFacilitiesCrick);
        myListFacilitiesBad = (RecyclerView)findViewById(R.id.myListFacilitiesbad);
        myListOptions = (RecyclerView)findViewById(R.id.myListOptions);
        myListCrikcetGroundTypes = (RecyclerView)findViewById(R.id.myListGroundTypes);
        btnBook = (Button) findViewById(R.id.buttonBook);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ground Details");
        startTime = (RelativeLayout) findViewById(R.id.startTimeLayout);
        endTime = (RelativeLayout) findViewById(R.id.endtimeLayout);

        if(getIntent().getExtras().getString(getString(R.string.extras_matchtype_cricket))!= null)
        {
            groundName = (TextView) findViewById(R.id.groundName);
            groundArea = (TextView) findViewById(R.id.groundArea);


            mFacilitiSlotsList = getIntent().getParcelableArrayListExtra(getString(R.string.extras_slots));
            mSubFacilitiesList = AppUtils.getSubFacilities(AppUtils.getFacilities(mFacilitiSlotsList));
            mSubFacilities = AppUtils.getSubFacilityFromId(mSubFacilitiesList, getIntent().getIntExtra(getString(R.string.extras_sub_facility_id), 0));

            groundName.setText(mSubFacilities.getSubFacilityName());
            groundArea.setText(mSubFacilities.getAddressLine1());
            layoutCrikcet.setVisibility(View.VISIBLE);
            layoutBadminton.setVisibility(View.GONE);
            RecyclerView.LayoutManager mLayoutManagerVer = new LinearLayoutManager(MatchScheduleActivity.this,LinearLayoutManager.VERTICAL, false);
            myListCrikcetGroundTypes.setLayoutManager(mLayoutManagerVer);
            myListCrikcetGroundTypes.setItemAnimator(new DefaultItemAnimator());
            RecyclerView.LayoutManager mLayoutManagerVer1 = new LinearLayoutManager(MatchScheduleActivity.this,LinearLayoutManager.VERTICAL, false);

            myListOptions.setLayoutManager(mLayoutManagerVer1);

            RecyclerView.LayoutManager mLayoutManagerHor = new LinearLayoutManager(MatchScheduleActivity.this,LinearLayoutManager.HORIZONTAL, false);
            myListFacilitiesCkt.setLayoutManager(mLayoutManagerHor);


            mGroundTypeAdapter = new SurfaceAdapter(MatchScheduleActivity.this,getGroundTypes());
            myListCrikcetGroundTypes.setAdapter(mGroundTypeAdapter);

            mFacilitiesAdapter = new FacilitiesAdapter(MatchScheduleActivity.this,getFacilities(Constants.LIST_TYPE_FACILITIES),Constants.LIST_TYPE_FACILITIES);
            myListFacilitiesCkt.setAdapter(mFacilitiesAdapter);
            mFacilitiesAdapter = new FacilitiesAdapter(MatchScheduleActivity.this,getFacilities(Constants.LIST_TYPE_OPTIONS),Constants.LIST_TYPE_OPTIONS);
            myListOptions.setAdapter(mFacilitiesAdapter);
            initDateDialog(dateCrick);


        }else if(getIntent().getExtras().getString(getString(R.string.extras_matchtype_bad))!= null)
        {
            coutName = (TextView) findViewById(R.id.courtName);
            coutArea = (TextView) findViewById(R.id.courtArea);

            layoutCrikcet.setVisibility(View.GONE);
            layoutBadminton.setVisibility(View.VISIBLE);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MatchScheduleActivity.this,LinearLayoutManager.HORIZONTAL, false);
            myListFacilitiesBad.setLayoutManager(mLayoutManager);
            myListCrikcetGroundTypes.setItemAnimator(new DefaultItemAnimator());

            mLayoutManager = new LinearLayoutManager(MatchScheduleActivity.this,LinearLayoutManager.VERTICAL, false);
            myListOptions.setLayoutManager(mLayoutManager);
            mFacilitiesAdapter = new FacilitiesAdapter(MatchScheduleActivity.this,getFacilities(Constants.LIST_TYPE_FACILITIES),Constants.LIST_TYPE_FACILITIES);
            myListFacilitiesBad.setAdapter(mFacilitiesAdapter);
            mFacilitiesAdapter = new FacilitiesAdapter(MatchScheduleActivity.this,getFacilities(Constants.LIST_TYPE_OPTIONS),Constants.LIST_TYPE_OPTIONS);
            myListOptions.setAdapter(mFacilitiesAdapter);
            initDateDialog(dateBat);


        }

        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.pager_item,
                R.layout.pager_item,
                R.layout.pager_item,
                R.layout.pager_item};

        // adding bottom dots
        addBottomDots(0);

        // making notification bar transparent
        //changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MatchScheduleActivity.this,BookingMatchActivity.class);
                intent.putExtra(getString(R.string.extras_slots),mFacilitiSlotsList);
                intent.putExtra(getString(R.string.extras_sub_facility_id),mSubFacilities.getSubFacilityId());

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
       finish();
        return true;
    }

    public void onClicView(View view)
    {
        switch (view.getId())
        {
            case R.id.dateCricket:
                initDateDialog(dateCrick);
                break;
            case R.id.dateBad:
                initDateDialog(dateBat);
                break;
            case R.id.startTimeLayout:
                initTimeDialog(startTime,"start");
                break;
            case R.id.endtimeLayout:
                initTimeDialog(endTime,"end");
                break;
        }
    }

    private void initDateDialog(LinearLayout dateCrick) {

        final ImageView preDate =(ImageView)dateCrick.findViewById(R.id.preDate);
        final ImageView nextDate =(ImageView)dateCrick.findViewById(R.id.nextDate);
        final ImageView cal =(ImageView)dateCrick.findViewById(R.id.calender);
        final ImageView arrow =(ImageView)dateCrick.findViewById(R.id.arrow);
        final TextView date =(TextView)dateCrick.findViewById(R.id.date);

        final Calendar myCalender = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppUtils.createDatepicker(MatchScheduleActivity.this, date, preDate, nextDate, myCalender);
            }
        });

    }
    private void initTimeDialog(RelativeLayout timepicker,String type)
    {
        final TextView time;
        if(type.equalsIgnoreCase("start"))
        {
            time =(TextView)timepicker.findViewById(R.id.date);
        }
        else
        {
            time =(TextView)timepicker.findViewById(R.id.txtEndtime);
        }
        final Calendar myCalender = Calendar.getInstance();
        AppUtils.createTimePicker(MatchScheduleActivity.this,time,myCalender);
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
            } else {
                // still pages are left
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };
    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            Glide.with(MatchScheduleActivity.this)
                    .load("https://s18.postimg.org/v7hm5s7zd/cricketbg.png")
                    //.placeholder(R.drawable.cricketbg)
                    .centerCrop()
                    .into(imageView);
            imageView.setImageResource(R.drawable.cricketbg);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    public List<GroundType> getGroundTypes()
    {
        List<GroundType> tmts = new ArrayList();
        tmts.add(new GroundType("","Turf / Matted Wicket"));
        tmts.add(new GroundType("","Bowling Machine"));
        tmts.add(new GroundType("", "Coaching"));


        return  tmts;
    }
    public List<GroundType> getFacilities(String type)
    {
        List<GroundType> tmts = new ArrayList();
        if(type.equalsIgnoreCase(Constants.LIST_TYPE_FACILITIES)) {

            if(mSubFacilities.isHasAmbulance())
            {
                tmts.add(new GroundType("",Constants.FACILITY_AMBULANCE));
            }
            else if(mSubFacilities.isHasBallPurchase())
            {
                tmts.add(new GroundType("",Constants.FACILITY_BALL_PURCHASE));
            }
            else if(mSubFacilities.isHasCafeteria())
            {
                tmts.add(new GroundType("",Constants.FACILITY_CAFETARIA));
            }
            else if(mSubFacilities.isHasFirstAid())
            {
                tmts.add(new GroundType("",Constants.FACILITY_FIRST_AID));
            }
            else if(mSubFacilities.isHasFloodLight())
            {
                tmts.add(new GroundType("",Constants.FACILITY_FLOOD_LIGHT));
            }
            else if(mSubFacilities.isHasRestRoom())
            {
                tmts.add(new GroundType("",Constants.FACILITY_RESTROOM));
            }
            else if(mSubFacilities.isHasShower())
            {
                tmts.add(new GroundType("",Constants.FACILITY_SHOWER));
            }
            else if(mSubFacilities.isHasShoeRental())
            {
                tmts.add(new GroundType("",Constants.FACILITY_SHOE));
            }

        }
        else
        {
            tmts.add(new GroundType("", "Navigation"));
            /*tmts.add(new GroundType("", "Videos"));
            tmts.add(new GroundType("", "Images")); */
        }


        return  tmts;
    }
}
