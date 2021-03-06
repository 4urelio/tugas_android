package com.example.tugas_harian;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.text.Html.fromHtml;
import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    EditText textUsername;
    EditText textEmail;
    EditText textPass;
    Button buttonTombol;
    TextView textRegister;
    DatabaseHelper db;
    private FirebaseFirestore firebaseFirestoreDb;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Alarm alarm = new Alarm(this);
        alarm.cancelAlarm();
        alarm.setAlarm();
       //db = new DatabaseHelper(this);
        textEmail = (EditText) findViewById(R.id.Email);
        textPass = (EditText) findViewById(R.id.Pass);
        buttonTombol = (Button) findViewById(R.id.button);
        textRegister = (TextView) findViewById(R.id.SignUp);
        firebaseFirestoreDb = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
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
                //Boolean res = db.checkUser(email,pass);
                firebaseAuth.signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                                }else{
                                    Toast.makeText(MainActivity.this, "Error "+ task.getException().getMessage(), LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}
