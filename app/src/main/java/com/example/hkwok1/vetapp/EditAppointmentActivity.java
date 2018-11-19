package com.example.hkwok1.vetapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

public class EditAppointmentActivity extends AppCompatActivity {
    private static final String url = "jdbc:mysql://localhost:3306/t1vetApp";
    private static final String username = "root";
    private static final String password = "LegoMagazine532";
    private static String selectedType, selectedDate, selectedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_appointment);

        Spinner appointmentType = findViewById(R.id.appointmentType);
        appointmentType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedType = parent.getSelectedItem().toString();
            }
        });

        CalendarView date = findViewById(R.id.dateOptions);
        long m = date.getDate();
        selectedDate = android.text.format.DateFormat.format("MM/dd/yyyy", new Date(m)).toString();

        Spinner time = findViewById(R.id.timeSlot);
        time.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedTime = parent.getSelectedItem().toString();
            }
        });

        Button notesButton = findViewById(R.id.notesButton);
        notesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    public static class setData extends AsyncTask<Void, Void, Void>{
        private String result;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                result = "DB Connection Succeeded\n";
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection(url, username, password);
                String queryString = "update t1vetApp.appointments set appointment_type = " + selectedType + ", date = " + selectedDate + ", time = " + selectedTime + "where appointments.pet_id = pets.pet_id";
                Statement st = c.createStatement();
                st.executeQuery(queryString);
                st.close();
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