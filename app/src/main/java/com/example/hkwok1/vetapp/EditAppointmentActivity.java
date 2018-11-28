package com.example.hkwok1.vetapp;

import android.content.Intent;
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
    private static final String url = "jdbc:mysql://10.250.73.231:3306/t1vetapp";
    private static final String username = "root";
    private static final String password = "test5";
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
                startActivity(new Intent(EditAppointmentActivity.this, AddNotesActivity.class));
            }
        });

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new updateData().execute();
                startActivity(new Intent(EditAppointmentActivity.this, HomePageActivity.class));
            }
        });

        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditAppointmentActivity.this, HomePageActivity.class));
            }
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditAppointmentActivity.this, HomePageActivity.class));
            }
        });
    }

    public static class updateData extends AsyncTask<Void, Void, Void>{
        private String result;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                result = "DB Connection Succeeded\n";
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection(url, username, password);
                String queryString = "UPDATE t1vetapp.appointments SET appointment_type = " + selectedType + ", date = " + selectedDate + ", time = " + selectedTime + "WHERE appointments.appointment_id = 1 AND appointments.pet_name = 'Polly'";
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

/* The database query statement needs a way to get the name of the pet that was chosen when the user chose an appointment to edit
 * on the Existing Appointments page. This will help to match the appointment that's being edited to its entry in the
 * database. */