package com.example.hkwok1.vetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // DatabaseHelper helper = new DatabaseHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signUp = findViewById(R.id.suButton);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });

        Button login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
    }

    public void onButtonClick(View v){
        EditText a = findViewById(R.id.username);
        String str = a.getText().toString();
        EditText b = findViewById(R.id.password);
        String pass = b.getText().toString();

        String password = ""; //helper.searchPass(str);
        if(pass.equals(password)) {
            Intent i = new Intent(this, HomePageActivity.class);
            i.putExtra("username", str);
            startActivity(i);
        }
        else {
            Toast temp = Toast.makeText(MainActivity.this , "Incorrect Email/Password" , Toast.LENGTH_SHORT);
            temp.show();
        }

    }

    public void openSignUp(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
