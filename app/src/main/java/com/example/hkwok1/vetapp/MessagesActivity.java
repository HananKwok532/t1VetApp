package com.example.hkwok1.vetapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        Button log = findViewById(R.id.logButton);
        log.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MessagesActivity.this, LogMessage.class));
            }
        });

        Button ask = findViewById(R.id.askButton);
        ask.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MessagesActivity.this, AskMessage.class));
            }
        });

        ImageButton home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MessagesActivity.this, HomePageActivity.class));
            }
        });
    }
}
