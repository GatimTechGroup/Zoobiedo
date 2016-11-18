package com.zoobiedo.org.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zoobiedo.org.R;
import com.zoobiedo.org.model.FacilitySlotsRequestData;
import com.zoobiedo.org.utils.AppUtils;
import com.zoobiedo.org.utils.Constants;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener,LocationListener {



    //RecyclerView recyclerView;
    EditText locatonSearchBox;
    RelativeLayout cricket,football,badminton;
    LinearLayout cricketFacility,footballFacility,badmintonFacility;
    FacilitySlotsRequestData mFacilitySlotsRequestData = new FacilitySlotsRequestData();
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    public static final int REQUEST_ID_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView =  navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.nav_name);
        ImageView nav_image = (ImageView)hView.findViewById (R.id.nav_image);
         locatonSearchBox = (EditText)findViewById(R.id.edtSearch);
        locatonSearchBox.setVisibility(View.GONE);

        cricket = (RelativeLayout)findViewById(R.id.cricket);
        cricket.setOnClickListener(this);
        football = (RelativeLayout)findViewById(R.id.football);
        football.setOnClickListener(this);
        badminton = (RelativeLayout)findViewById(R.id.badminton);
        badminton.setOnClickListener(this);

        cricketFacility = (LinearLayout)findViewById(R.id.cricketFacility);
        cricketFacility.setVisibility(View.GONE);
        footballFacility = (LinearLayout)findViewById(R.id.footballFacility);
        footballFacility.setVisibility(View.GONE);
        badmintonFacility = (LinearLayout)findViewById(R.id.badmintonFacility);
        badmintonFacility.setVisibility(View.GONE);


        if(getIntent().getExtras() != null) {
            CharSequence name = getIntent().getStringExtra("name");
            nav_user.setText(name);
            Glide.with(this).load(getIntent().getStringExtra("profilePic")).into(nav_image);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabled = locationManager
                .isProviderEnabled(LocationManager
                        .GPS_PROVIDER);

 // check if enabled and if not send user to the GSP settings
// Better solution would be to display a dialog and suggesting to
// go to the settings
        if (!enabled) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }else
        {
            if(!AppUtils.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_ID_PERMISSION);
            }
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode)
        {
            case REQUEST_ID_PERMISSION:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // permissions granted.
                    try {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                }
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.action_search)
        {
         locatonSearchBox.setVisibility(View.VISIBLE);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent intent = new Intent(MainActivity.this,ActivityMenuSub.class);
        if (id == R.id.nav_changePwd) {
            // Handle the camera action
            intent.putExtra(getString(R.string.extras_menu_changepwd),"");
            startActivity(intent);
        } else if (id == R.id.nav_about) {
            intent.putExtra(getString(R.string.extras_menu_aboutUs),"");
            startActivity(intent);

        } else if (id == R.id.nav_help) {
            intent.putExtra(getString(R.string.extras_menu_help),"");
            startActivity(intent);

        } else if (id == R.id.nav_home) {

        } else if (id == R.id.nav_editProf) {
            intent.putExtra(getString(R.string.extras_menu_editprof),"");
            startActivity(intent);

        }
        else if (id == R.id.nav_logout) {
            finish();

        }
       /* else if (id == R.id.nav_notifications) {

        }*/
        else if (id == R.id.nav_order_history) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.cricket:
                cricketFacility.setVisibility(View.VISIBLE);
                badmintonFacility.setVisibility(View.GONE);
                footballFacility.setVisibility(View.GONE);
                inintFacilities(cricketFacility, Constants.LIST_GROUNDS_CRIC);
                break;
            case R.id.football:
                cricketFacility.setVisibility(View.GONE);
                badmintonFacility.setVisibility(View.GONE);
                footballFacility.setVisibility(View.VISIBLE);
                inintFacilities(footballFacility,Constants.LIST_GROUNDS_CRIC);
                break;
            case  R.id.badminton:
                cricketFacility.setVisibility(View.GONE);
                badmintonFacility.setVisibility(View.VISIBLE);
                footballFacility.setVisibility(View.GONE);
                inintFacilities(badmintonFacility,Constants.LIST_GROUNDS_BAD);
                break;
            case R.id.buttonSearch:

                break;
        }

    }

    private void inintFacilities(final LinearLayout cricketFacility,final String type) {

        //LinearLayout
        final LinearLayout facilityGround = (LinearLayout)cricketFacility.findViewById(R.id.cricketGround);
        final LinearLayout facilityNets = (LinearLayout)cricketFacility.findViewById(R.id.cricketNets);
        final LinearLayout facilityPractice = (LinearLayout)cricketFacility.findViewById(R.id.practice);
        final LinearLayout facilityOrgs = (LinearLayout)cricketFacility.findViewById(R.id.organiser);



        Button search = (Button) cricketFacility.findViewById(R.id.buttonSearch);
        final ImageView preDate =(ImageView)cricketFacility.findViewById(R.id.preDate);
        final ImageView nextDate =(ImageView)cricketFacility.findViewById(R.id.nextDate);
        final ImageView cal =(ImageView)cricketFacility.findViewById(R.id.calender);
        final ImageView arrow =(ImageView)cricketFacility.findViewById(R.id.arrow);
        final TextView date =(TextView)cricketFacility.findViewById(R.id.date);

        final Calendar myCalender = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        final Intent intent = new Intent(MainActivity.this,GameGroundsActivity.class);
        if(type.equalsIgnoreCase(Constants.LIST_GROUNDS_CRIC)) {
            mFacilitySlotsRequestData.setSportsType(1);
            mFacilitySlotsRequestData.setCityID(1);
            intent.putExtra(getString(R.string.extras_matchtype_cricket),type);

        }else
        {
            mFacilitySlotsRequestData.setSportsType(4);
            mFacilitySlotsRequestData.setCityID(1);
            intent.putExtra(getString(R.string.extras_matchtype_bad),type);

        }

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppUtils.createDatepicker(MainActivity.this,date,preDate,nextDate,myCalender);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(date.getText().toString().equalsIgnoreCase("Date"))
                {
                    Toast.makeText(MainActivity.this, "Please Select Date to proceed!", Toast.LENGTH_SHORT).show();
                }else {
                    mFacilitySlotsRequestData.setSearchDate(AppUtils.getTmeStamp(date.getText().toString()));
                    intent.putExtra(getString(R.string.extras_req_data), mFacilitySlotsRequestData);
                    startActivity(intent);
                }
            }
        });
        facilityGround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    facilityGround.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.facilitySelection));
                    facilityPractice.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));
                    facilityNets.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));
                    facilityOrgs.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));



            }
        });
        facilityPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facilityPractice.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.facilitySelection));
                facilityGround.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));
                facilityNets.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));
                facilityOrgs.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));


            }
        });
        facilityNets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                facilityNets.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.facilitySelection));
                facilityGround.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));
                facilityPractice.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));
                facilityOrgs.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));

            }
        });
        facilityOrgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facilityOrgs.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.facilitySelection));
                facilityGround.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));
                facilityPractice.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));
                facilityNets.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.transparent));


            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cricketFacility.setVisibility(View.GONE);
            }
        });



    }

    @Override
    public void onLocationChanged(Location location) {

        mFacilitySlotsRequestData.setGPSCoordinates(location.getLatitude()+","+location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
