package com.zoobiedo.org.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.zoobiedo.org.R;
import com.zoobiedo.org.adapter.GroundsAdapter;
import com.zoobiedo.org.adapter.NetsAdapter;
import com.zoobiedo.org.adapter.OrganizersAdapter;
import com.zoobiedo.org.adapter.TournmentAdapter;
import com.zoobiedo.org.model.Facilities;
import com.zoobiedo.org.model.FacilitySlots;
import com.zoobiedo.org.model.FacilitySlotsRequestData;
import com.zoobiedo.org.model.Grounds;
import com.zoobiedo.org.model.Organizers;
import com.zoobiedo.org.model.SubFacilities;
import com.zoobiedo.org.model.Tournments;
import com.zoobiedo.org.services.ApiClient;
import com.zoobiedo.org.services.ApiInterface;
import com.zoobiedo.org.utils.AppUtils;
import com.zoobiedo.org.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GroundsListFragment extends Fragment {


    RecyclerView myRecyclerView;
    GroundsAdapter myAdapter;
    TournmentAdapter myAdapterTmts;
    OrganizersAdapter myAdapterOrgs;
    NetsAdapter myAdapterNets;
    FacilitySlotsRequestData mFacilitySlotsRequestData = new FacilitySlotsRequestData();
    ProgressDialog mpProgressDialog;
    ArrayList<FacilitySlots> mFailitySlotsList = new ArrayList<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grounds_list, container, false);
        initWidgets(view);
        return view;
    }

    private void initWidgets(View view) {

        mpProgressDialog = new ProgressDialog(getActivity());
        myRecyclerView = (RecyclerView)view.findViewById(R.id.myList);
        myRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(mLayoutManager);
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mFacilitySlotsRequestData = getArguments().getParcelable(getString(R.string.extras_req_data));
        /*mFacilitySlotsRequestData.setCityID(1);
        mFacilitySlotsRequestData.setGPSCoordinates("12.917578,77.607816");
        mFacilitySlotsRequestData.setSportsType(1);
        mFacilitySlotsRequestData.setSearchDate("/Date(1462406400000)/");*/


        AppUtils.createProgressBar(mpProgressDialog);
        final Call<ArrayList<FacilitySlots>> mFacilitySlots = ApiClient.getRetrofitClientCustomerBooking().create(ApiInterface.class).getListOfFacilitySlots(mFacilitySlotsRequestData);

        mFacilitySlots.enqueue(new Callback<ArrayList<FacilitySlots>>() {
            @Override
            public void onResponse(Call<ArrayList<FacilitySlots>> call, Response<ArrayList<FacilitySlots>> response) {

                mFailitySlotsList = response.body();
                Log.d("debug","facility slots"+mFailitySlotsList.size());
                mpProgressDialog.dismiss();
                myAdapter = new GroundsAdapter(getActivity(), mFailitySlotsList,Constants.LIST_GROUNDS_CRIC);
                myRecyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<FacilitySlots>> call, Throwable t) {

            }
        });

       /* if(getArguments().getString(getString(R.string.extras_matchtype_cricket))!= null)
        {
            myAdapter = new GroundsAdapter(getActivity(), mFailitySlotsList,Constants.LIST_GROUNDS_CRIC);
            myRecyclerView.setAdapter(myAdapter);
        }
        else if (getArguments().getString(getString(R.string.extras_matchtype_bad))!= null) {
            //myAdapter = new GroundsAdapter(getActivity(), getGrounds(),Constants.LIST_GROUNDS_BAD);
           // myRecyclerView.setAdapter(myAdapter);
        } else if (getArguments().getString(Constants.LIST_NETS) != null) {
            myAdapterNets = new NetsAdapter(getActivity(), getGrounds());
            myRecyclerView.setAdapter(myAdapterNets);
        } else if (getArguments().getString(Constants.LIST_TMT) != null) {
            myAdapterTmts = new TournmentAdapter(getActivity(), getTournments());
            myRecyclerView.setAdapter(myAdapterTmts);
        } else if (getArguments().getString(Constants.LIST_ORGS) != null) {
            myAdapterOrgs = new OrganizersAdapter(getActivity(), getOrganisers());
            myRecyclerView.setAdapter(myAdapterOrgs);
        }*/


    }

    public List<Grounds> getGrounds()
    {
        List<Grounds> grounds = new ArrayList();

        grounds.add(new Grounds("JP Nagar CricketAcademy","Jayanagar 4th Block","5km","4.0"));
        grounds.add(new Grounds("Decathlon Sports India pvt ltd","Sarjapur","5km","4.0"));
        grounds.add(new Grounds("JP Nagar CricketAcademy","Jayanagar 4th Block","5km","4.0"));
        grounds.add(new Grounds("JP Nagar CricketAcademy", "Jayanagar 4th Block", "5km", "4.0"));
        grounds.add(new Grounds("JP Nagar CricketAcademy", "Jayanagar 4th Block", "5km", "4.0"));
        grounds.add(new Grounds("JP Nagar CricketAcademy", "Jayanagar 4th Block", "5km", "4.0"));

        return  grounds;
    }


    public List<Tournments> getTournments()
    {
        List<Tournments> tmts = new ArrayList();
        tmts.add(new Tournments("Tournment1","3000","18-Sep-2016 10AM"));
        tmts.add(new Tournments("Tournment2","3000","18-Sep-2016 10AM"));
        tmts.add(new Tournments("Tournment3","4000","18-Sep-2016 10AM"));
        tmts.add(new Tournments("Tournment1","3000","18-Sep-2016 10AM"));
        tmts.add(new Tournments("Tournment2","3000","18-Sep-2016 10AM"));
        tmts.add(new Tournments("Tournment3","4000","18-Sep-2016 10AM"));

        return  tmts;
    }
    public List<Organizers> getOrganisers()
    {
        List<Organizers> orgs = new ArrayList();
        orgs.add(new Organizers("JP Nagar CricketAcademy","Jayanagar 4th Block","KA Member","4.0"));
        orgs.add(new Organizers("Decathlon Sports India pvt ltd","Sarjapur","5km","4.0"));
        orgs.add(new Organizers("JP Nagar CricketAcademy","Jayanagar 4th Block","KA Member","4.0"));
        orgs.add(new Organizers("Decathlon Sports India pvt ltd","Sarjapur","5km","4.0"));
        orgs.add(new Organizers("JP Nagar CricketAcademy","Jayanagar 4th Block","KA Member","4.0"));
        orgs.add(new Organizers("Decathlon Sports India pvt ltd","Sarjapur","5km","4.0"));

        return  orgs;
    }
}
