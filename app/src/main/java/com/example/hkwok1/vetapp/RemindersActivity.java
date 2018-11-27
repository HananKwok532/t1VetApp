package com.example.hkwok1.vetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.support.v7.app.AlertDialog;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

public class RemindersActivity extends AppCompatActivity {

    /*Date currentTime = Calendar.getInstance().getTime();
    Date eventTime = Calendar.getInstance().getTime();
    Button addButton = (Button)(findViewById(R.id.saveDate));
    DatabaseTable db = new DatabaseTable(this);

    public void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Cursor c = db.getEvents(query, null);
            // process Cursor and display results
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                createEvent();
            }
        });
        displayReminder();
    }

    public void createEvent(){
        /* reminders will automatically go off
        * if currentDate has an appointment scheduled
        create an event to save in database */
        /*Intent intent = new Intent(Intent.ACTION_INSERT);
        handleIntent(intent);  // intent to return all appointments from database
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.Events.TITLE, "Appointment Reminder");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Vets Office");
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "Taking care of your pets!");

        // Setting dates
        GregorianCalendar calDate = new GregorianCalendar(2019, 3, 20);
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                calDate.getTimeInMillis());

        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                calDate.getTimeInMillis());
    }

    public void displayReminder(){
        /* if currentDay == dayOfEvent
        * display alertDialog
        * text 'You have an appointment today' */

        /*AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Appointment Reminder");
        alert.setMessage("You have an appointment today");
        alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        if(currentTime.compareTo(eventTime) == 0){
            AlertDialog newAlert = alert.create();
            newAlert.show();

        }
    }*/
}
