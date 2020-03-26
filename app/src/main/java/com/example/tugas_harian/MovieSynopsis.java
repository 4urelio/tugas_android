package com.example.tugas_harian;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MovieSynopsis extends AppCompatActivity {
    ImageView mainImageView;
    TextView title, description, synopsis;
    String title2, synopsis2;
    String synopsis3 = "Synopsis";
    int photos2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_movies_synopsis);

        mainImageView= findViewById(R.id.movie_photo);
        title= findViewById(R.id.Movie_name);
        description= findViewById(R.id.Movie_desc);
        synopsis = findViewById(R.id.Movie_desc_detail);
        getData();
        setData();
    }

    private void setData(){
        title.setText(title2);
        description.setText(synopsis2);
        synopsis.setText(synopsis3);
        mainImageView.setImageResource(photos2);
    }

    private void getData(){
        if(getIntent().hasExtra("Photos") && getIntent().hasExtra("Title") && getIntent().hasExtra("Synopsis")){
            title2 = getIntent().getStringExtra("title");
            synopsis3 = getIntent().getStringExtra("Synopsis");
            photos2 = getIntent().getIntExtra("Photos", 1);
        }else{
            Toast.makeText(this,"no Data", Toast.LENGTH_SHORT).show();
        }

    }


}
