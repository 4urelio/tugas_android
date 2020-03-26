package com.example.tugas_harian;

import java.util.ArrayList;

public class MovieInfos {
    private static String[] filmNames = {
      "Avengers (2012)","Avengers: Age of Ultron", "Avengers: Infinity Wars", "Avengers: Endgame"
    };
    private static String[] filmdetails = {
      "The Avengers, is a 2012 American superhero film based on the Marvel Comics superhero team of the same name, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures.",
            "Avengers: Age of Ultron is a 2015 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures.",
            "Avengers: Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. ",
            "Avengers: Endgame is a 2019 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. "
    };

    private static int[] filmimages = {
        R.drawable.avengers, R.drawable.avengers2, R.drawable.avengers3, R.drawable.avengers4
    };

    static ArrayList<Datamovies> getListData(){
        ArrayList<Datamovies> list = new ArrayList<>();
        for (int postition = 0; postition < filmNames.length;postition++){
            Datamovies datamovies = new Datamovies();
            datamovies.setNameMovie(filmNames[postition]);
            datamovies.setMovieDetails(filmdetails[postition]);
            datamovies.setPhotos(filmimages[postition]);
            list.add(datamovies);
        }
        return list;
    }
}
