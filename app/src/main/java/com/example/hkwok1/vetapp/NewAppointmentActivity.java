package com.example.hkwok1.vetapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

public class NewAppointmentActivity extends AppCompatActivity {
    private static final String url = "";
    private static final String username = "";
    private static final String password = "";
    private static String selectedType, selectedDate, selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_appointment);
        ImageButton home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NewAppointmentActivity.this, HomePageActivity.class));
            }
        });
        Button back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NewAppointmentActivity.this, ExistingAppointmentsActivity.class));
            }
        });

        Button notes = findViewById(R.id.notesButton);
        notes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NewAppointmentActivity.this, AddNotesActivity.class));
            }
        });

        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NewAppointmentActivity.this, ExistingAppointmentsActivity.class));
            }
        });

        CalendarView date = findViewById(R.id.DateOptions);
        long m = date.getDate();
        selectedDate = DateFormat.format("MM/dd/yyyy", new Date(m)).toString();

        Spinner typeSpin = findViewById(R.id.AppointmentType);
        typeSpin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedType = parent.getSelectedItem().toString();
            }
        });

        Spinner timeSpin = findViewById(R.id.TimeSlot);
        timeSpin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedTime = parent.getSelectedItem().toString();
            }
        });

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new setData().execute();
            }
        });
    }

    public static class setData extends AsyncTask<Void, Void, Void> {
        private String result;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                result = "DB Connection Succeeded\n";
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection(url, username, password);
                String queryString = "INSERT INTO t1vetapp.appointments (appointment_type, date, time) VALUES (" + selectedType + ", " + selectedDate + ", " + selectedTime + ")";
                Statement st = c.createStatement();
                st.executeQuery(queryString);
                c.close();
            } catch (Exception e) {
                e.printStackTrace();
                result = "DB Connection Failed:\n" + e.toString();
            }
            return null;
        }

        protected void onPostExecute(Void res) {

        }
    }
}
