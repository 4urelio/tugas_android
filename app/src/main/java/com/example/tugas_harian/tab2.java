package com.example.tugas_harian;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab2 extends Fragment {

    private ArrayList<Datamovies> list;
    public tab2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab2, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        list.addAll(MovieInfos.getListData());

        RecyclerView film = view.findViewById(R.id.recycleView);
        film.setHasFixedSize(true);
        RecycleViewAdapter recycleviewAdapter = new RecycleViewAdapter(list);
        film.setLayoutManager(new LinearLayoutManager(getActivity()));
        film.setAdapter(recycleviewAdapter);
    }
}
