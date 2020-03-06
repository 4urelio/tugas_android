package com.example.tugas_harian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText pass;
    Button Tombol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.Email);
        pass = findViewById(R.id.Pass);
        Tombol = findViewById(R.id.button1);

        Tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Welcome!!!!", Toast.LENGTH_LONG).show();
                    openActivity2();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Email/password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent( this, Main2Activity.class);
        startActivity(intent);
    }
}
