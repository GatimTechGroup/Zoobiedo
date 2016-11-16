package com.zoobiedo.org.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zoobiedo.org.R;
import com.zoobiedo.org.model.Organizers;

public class OrganizersActiivty extends AppCompatActivity {

    Button btnBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizers_actiivty);

        btnBook = (Button) findViewById(R.id.requestBooking);

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(OrganizersActiivty.this,BookingMatchActivity.class));
            }
        });

    }
}
