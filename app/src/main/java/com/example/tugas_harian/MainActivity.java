package com.example.tugas_harian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.Html.fromHtml;

public class MainActivity extends AppCompatActivity {

    EditText textEmail;
    EditText textPass;
    Button buttonTombol;
    TextView textRegister;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        textEmail = (EditText) findViewById(R.id.Email);
        textPass = (EditText) findViewById(R.id.Pass);
        buttonTombol = (Button) findViewById(R.id.button);
        textRegister = (TextView) findViewById(R.id.SignUp);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this,BuatRegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        buttonTombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textEmail.getText().toString().trim();
                String pass = textPass.getText().toString().trim();
                Boolean res = db.checkUser(email,pass);
                if (res == true){
                    Toast.makeText(MainActivity.this, "Successfully login", Toast.LENGTH_SHORT).show();
                    Intent keHomepage = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(keHomepage);
                }
                else {
                    Toast.makeText(MainActivity.this, "login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
