package com.example.hkwok1.vetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AskMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_message);
        ImageButton back = (ImageButton)findViewById(R.id.backLButton);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AskMessage.this, MessagesActivity.class));
            }
        });
        ImageButton submit = (ImageButton)findViewById(R.id.submitLButton);
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AskMessage.this, MessagesActivity.class));
            }
        });
    }
}
