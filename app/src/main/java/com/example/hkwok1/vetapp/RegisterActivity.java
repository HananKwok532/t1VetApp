package com.example.hkwok1.vetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    //DatabaseHelper helper = new DatabaseHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button back = findViewById(R.id.returnButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

        Button submit = findViewById(R.id.createButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignUpClick(v);
            }
        });
    }

    public void openLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onSignUpClick(View v) {
        if(v.getId() == R.id.createButton) {
            EditText firstName = findViewById(R.id.fnameEntry);
            EditText lastName = findViewById(R.id.lnameEntry);
            EditText phone = findViewById(R.id.phoneEntry);
            EditText email = findViewById(R.id.emailEntry);
            EditText uName = findViewById(R.id.usernameEntry);
            EditText pass = findViewById(R.id.passwordEntry);

            String fNameStr = firstName.getText().toString();
            String lNameStr = lastName.getText().toString();
            String phoneStr = phone.getText().toString();
            String emailStr = email.getText().toString();
            String uNameStr = uName.getText().toString();
            String passStr = pass.getText().toString();

            /*contact c = new contact();
            c.setFirstName(fNameStr);
            c.setLastName(lNameStr);
            c.setPhone(phoneStr);
            c.setEmail(emailStr);
            c.setUsername(uNameStr);
            c.setPass(passStr);
            openLogin(); */
        }
    }

}
