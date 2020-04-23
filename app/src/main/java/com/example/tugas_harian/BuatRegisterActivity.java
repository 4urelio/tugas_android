package com.example.tugas_harian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.Objects;

import static android.widget.Toast.LENGTH_SHORT;

public class BuatRegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText textEmail;
    EditText textPass;
    EditText confPass;
    Button buttonTombolRegister;
    TextView textRegister;
    private FirebaseFirestore firebaseFirestoreDb;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_register);
        firebaseFirestoreDb = FirebaseFirestore.getInstance();
        db = new DatabaseHelper(this);
        firebaseAuth = FirebaseAuth.getInstance();
        textEmail = (EditText) findViewById(R.id.textEmail);
        textPass = (EditText) findViewById(R.id.textPassword);
        //confPass = (EditText) findViewById(R.id.textconfPassword);
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
                //String confpassword = confPass.getText().toString().trim();

                /*if(password.equals(confpassword)){
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
                }*/
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(BuatRegisterActivity.this,"User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else{
                            Toast.makeText(BuatRegisterActivity.this,"Error "+ Objects.requireNonNull(task.getException()).getMessage(), LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
