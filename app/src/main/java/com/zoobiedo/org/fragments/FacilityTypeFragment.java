package com.zoobiedo.org.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zoobiedo.org.R;


public class FacilityTypeFragment extends Fragment implements View.OnClickListener {


    Button searchGrounds;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_facility_type, container, false);;
        initWidgets(view);
        return view;

    }

    private void initWidgets(View view) {

        searchGrounds = (Button)view.findViewById(R.id.buttonSearch);
        searchGrounds.setOnClickListener(this);


    }


    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.buttonSearch:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, new GroundsListFragment()).commit();
                break;
        }
    }
}
