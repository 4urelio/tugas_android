package com.example.tugas_harian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuatRegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText textEmail;
    EditText textPass;
    EditText confPass;
    Button buttonTombolRegister;
    TextView textRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_register);
        db = new DatabaseHelper(this);
        textEmail = (EditText) findViewById(R.id.textEmail);
        textPass = (EditText) findViewById(R.id.textPassword);
        confPass = (EditText) findViewById(R.id.textconfPassword);
        buttonTombolRegister = (Button) findViewById(R.id.button1);
        textRegister = (TextView) findViewById(R.id.registerLogin);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginintent = new Intent(BuatRegisterActivity.this, MainActivity.class);
                startActivity(loginintent);
            }
        });

        buttonTombolRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textEmail.getText().toString().trim();
                String password = textPass.getText().toString().trim();
                String confpassword = confPass.getText().toString().trim();

                if(password.equals(confpassword)){
                    long val = db.addUser(email,password);
                    if(val > 0){
                        Toast.makeText(BuatRegisterActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                        Intent kelogin = new Intent(BuatRegisterActivity.this, MainActivity.class);
                        startActivity(kelogin);
                    }
                    else {
                        Toast.makeText(BuatRegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(BuatRegisterActivity.this, "password is not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
