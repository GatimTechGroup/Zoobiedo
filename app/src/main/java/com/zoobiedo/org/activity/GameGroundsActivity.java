package com.zoobiedo.org.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.zoobiedo.org.R;
import com.zoobiedo.org.fragments.FacilityTypeFragment;
import com.zoobiedo.org.fragments.GroundsListFragment;
import com.zoobiedo.org.fragments.TournmentsFragment;
import com.zoobiedo.org.model.FacilitySlots;
import com.zoobiedo.org.model.FacilitySlotsRequestData;
import com.zoobiedo.org.utils.Constants;

import java.util.ArrayList;

public class GameGroundsActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout grounds,organizers,nets,tournments;
    GroundsListFragment fragment = new GroundsListFragment();
    Bundle  bundle = new Bundle();
    String listType;
    FacilitySlotsRequestData mFacilitySlotsRequestData = new FacilitySlotsRequestData();
    ArrayList<FacilitySlots> facilitySlots = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_type);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Grounds");
        grounds = (LinearLayout)findViewById(R.id.layoutgrounds);
        grounds.setOnClickListener(this);
        organizers = (LinearLayout)findViewById(R.id.layoutorgs);
        organizers.setOnClickListener(this);
        tournments = (LinearLayout)findViewById(R.id.layouttmt);
        tournments.setOnClickListener(this);
        nets = (LinearLayout)findViewById(R.id.layoutnets);
        nets.setOnClickListener(this);


        if(getIntent().getExtras().getString(getString(R.string.extras_matchtype_cricket))!= null)
        {
            bundle.putString(getString(R.string.extras_matchtype_cricket),Constants.LIST_GROUNDS_CRIC);
            listType = getIntent().getExtras().getString(getString(R.string.extras_matchtype_cricket));
            mFacilitySlotsRequestData = getIntent().getExtras().getParcelable(getString(R.string.extras_req_data));
            bundle.putString(getString(R.string.extras_matchtype_cricket),listType);
            bundle.putParcelable(getString(R.string.extras_req_data),mFacilitySlotsRequestData);
        }
        else if(getIntent().getExtras().getString(getString(R.string.extras_matchtype_bad))!= null)
        {
            bundle.putString(getString(R.string.extras_matchtype_bad),Constants.LIST_NETS);
            listType = getIntent().getExtras().getString(getString(R.string.extras_matchtype_bad));
            mFacilitySlotsRequestData = getIntent().getExtras().getParcelable(getString(R.string.extras_req_data));
            bundle.putString(getString(R.string.extras_matchtype_bad),listType);
            bundle.putParcelable(getString(R.string.extras_req_data),mFacilitySlotsRequestData);
        }
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View v) {

         fragment = new GroundsListFragment();
         bundle = new Bundle();
        switch (v.getId())
        {
            case R.id.layoutgrounds:
                bundle.putString(getString(R.string.extras_matchtype_cricket),Constants.LIST_GROUNDS_CRIC);
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                break;
            case R.id.layouttmt:
                bundle.putString(Constants.LIST_TMT,"");
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                break;
            case R.id.layoutorgs:
                bundle.putString(Constants.LIST_ORGS,"");
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                break;
            case R.id.layoutnets:
                bundle.putString(Constants.LIST_NETS,"");
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                break;
        }
    }
}
