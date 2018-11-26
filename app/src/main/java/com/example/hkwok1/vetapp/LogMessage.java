package com.example.hkwok1.vetapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class LogMessage extends AppCompatActivity {

    /*private static final String database_url = "jdbc:mysql://127.0.0.1:3306/t1vetapp";
    private static final String database_user = "root";
    private static final String database_pass = "";
    private static TextView message1;
    private static TextView message2;
    private static TextView message3;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_message);
        /*message1 = (TextView)findViewById(R.id.message1);
        message2 = (TextView)findViewById(R.id.message2);
        message3 = (TextView)findViewById(R.id.message3);*/
        ImageButton backL = (ImageButton)findViewById(R.id.backLButton);
        backL.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(LogMessage.this, MessagesActivity.class));
            }
        });
        ImageButton submitL = (ImageButton)findViewById(R.id.submitLButton);
        submitL.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(LogMessage.this, MessagesActivity.class));
            }
        });
    }
    /*public static class getDataFromDatabase extends AsyncTask<Void, Void, Void> {
        //references: http://developer.android.com/reference/android/os/AsyncTask.html
        //            https://www.youtube.com/watch?v=N0FLT5NdSNU (about the 7 min mark)
        private String queryResult;
        protected Void doInBackground(Void... arg0)  {
            try {
                queryResult = "Database connection success\n";

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(database_url, database_user, database_pass);
                String queryString = "select * from t1vetapp.messages limit 3";

                Statement st = con.createStatement();
                final ResultSet rs = st.executeQuery(queryString);
                ResultSetMetaData rsmd = rs.getMetaData();

                //do some things with the data you've retrieved
                while (rs.next()) {
                    queryResult += rsmd.getColumnName(1) + ": " + rs.getString(1) + "\n";
                }

                con.close(); //close database connection
            } catch (Exception e) {
                e.printStackTrace();
                //put the error into the TextView on the app screen
                queryResult = "Database connection failure\n" +  e.toString();
            }

            return null;
        }//end database connection via doInBackground

        //after processing is completed, post to the screen
        protected void onPostExecute(Void result) {
            //put the results into the TextView on the app screen
            message1.setText(queryResult);
        }
    }//end getDataFromDatabase()
    */
}

