package com.example.tugas_harian;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    private ArrayList<Datamovies> filmlist;

    public RecycleViewAdapter(ArrayList<Datamovies> list){
        this.filmlist = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_row,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Datamovies datamovies = filmlist.get(position);
        Glide.with(holder.itemView.getContext())
                .load(datamovies.getPhotos())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imagePhotos);
        holder.movieName.setText(datamovies.getNameMovie());
        holder.movieDetail.setText(datamovies.getMovieDetails());
        holder.btnSynopsis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(v.getContext(),MovieSynopsis.class);
                profile.putExtra("photos", datamovies.getPhotos());
                profile.putExtra("title",datamovies.getNameMovie());
                profile.putExtra("synopsis",datamovies.getMovieDetails());
                v.getContext().startActivity(profile);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filmlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imagePhotos;
        TextView movieName, movieDetail;
        Button btnSynopsis;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePhotos = itemView.findViewById(R.id.myImageView);
            movieName = itemView.findViewById(R.id.myText1);
            movieDetail = itemView.findViewById(R.id.myText2);
            btnSynopsis = itemView.findViewById(R.id.button_synopsis);
        }
    }


}
