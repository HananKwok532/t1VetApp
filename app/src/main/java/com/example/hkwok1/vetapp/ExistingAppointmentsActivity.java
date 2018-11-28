package com.example.hkwok1.vetapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ExistingAppointmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_appointments);

        Button edit = findViewById(R.id.editButton);
        edit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ExistingAppointmentsActivity.this, EditAppointmentActivity.class));
            }
        });

        Button delete = findViewById(R.id.deleteButton);
        delete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ExistingAppointmentsActivity.this, ExistingAppointmentsActivity.class));
            }
        });

        ImageButton home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ExistingAppointmentsActivity.this, HomePageActivity.class));
            }
        });
    }
}

