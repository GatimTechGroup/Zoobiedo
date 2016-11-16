package com.zoobiedo.org.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zoobiedo.org.R;

public class ActivityMenuSub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(getIntent().getExtras().getString(getString(R.string.extras_menu_changepwd))!= null) {
            setContentView(R.layout.layout_change_password);
        }
        else if(getIntent().getExtras().getString(getString(R.string.extras_menu_editprof))!= null)
        {
            setContentView(R.layout.layout_edit_profile);
        }
        else
        {
            setContentView(R.layout.activity_activity_menu_sub);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
