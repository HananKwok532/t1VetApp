package com.example.hkwok1.vetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AppointmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        Button appoint = findViewById(R.id.newButton);
        appoint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AppointmentsActivity.this, NewAppointmentActivity.class));
            }
        });

        Button exist = findViewById(R.id.existingButton);
        exist.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AppointmentsActivity.this, ExistingAppointmentsActivity.class));
            }
        });

        ImageButton home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AppointmentsActivity.this, HomePageActivity.class));
            }
        });
    }
}
