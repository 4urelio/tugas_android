package com.example.tugas_harian;

import java.util.ArrayList;

public class MovieInfos {
    private static String[] filmNames = {
      "Avengers","Avengers: Age of Ultron", "Avengers: Infinity Wars", "Avengers: Endgame"
    };
    private static String[] filmdetails = {
      "Marvel's The Avengers (classified under the name Marvel Avengers Assemble in the \"United Kingdom and Ireland)\", or simply The Avengers, is a 2012 American superhero film based on the Marvel Comics superhero team of the same name, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sixth film in the Marvel Cinematic Universe (MCU). The film was written and directed by Joss Whedon and features an ensemble cast that includes Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth, Scarlett Johansson, and Jeremy Renner as the titular Avengers team, alongside Tom Hiddleston, Clark Gregg, Cobie Smulders, Stellan Skarsgård, and Samuel L. Jackson. In the film, Nick Fury, director of the spy agency S.H.I.E.L.D., recruits Tony Stark, Steve Rogers, Bruce Banner, and Thor to form a team that must stop Thor's brother Loki from subjugating Earth.",
            "Avengers: Age of Ultron is a 2015 American superhero film based on the Marvel Comics \"superhero team the Avengers\", produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012's The Avengers and the eleventh film in the Marvel Cinematic Universe (MCU). The film was written and directed by Joss Whedon and features an ensemble cast that includes Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans, Scarlett Johansson, Jeremy Renner, Don Cheadle, Aaron Taylor-Johnson, Elizabeth Olsen, Paul Bettany, Cobie Smulders, Anthony Mackie, Hayley Atwell, Idris Elba, Stellan Skarsgård, James Spader, and Samuel L. Jackson. In the film, the Avengers fight Ultron, an artificial intelligence obsessed with causing human extinction.",
            "Avengers: Infinity War is a 2018 American superhero film based on the Marvel Comics \"superhero team the Avengers,\" produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012's The Avengers and 2015's Avengers: Age of Ultron, and the nineteenth film in the Marvel Cinematic Universe (MCU). It was directed by Anthony and Joe Russo, written by Christopher Markus and Stephen McFeely, and features an ensemble cast including Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans, Scarlett Johansson, Benedict Cumberbatch, Don Cheadle, Tom Holland, Chadwick Boseman, Paul Bettany, Elizabeth Olsen, Anthony Mackie, Sebastian Stan, Danai Gurira, Letitia Wright, Dave Bautista, Zoe Saldana, Josh Brolin, and Chris Pratt. In the film, the Avengers and the Guardians of the Galaxy attempt to prevent Thanos from collecting the six all-powerful Infinity Stones as part of his quest to kill half of all life in the universe.",
            "Avengers: Endgame is a 2019 American superhero film based on the Marvel Comics superhero \"team the Avengers, produced\" by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012's The Avengers, 2015's Avengers: Age of Ultron, and 2018's Avengers: Infinity War, and the twenty-second film in the Marvel Cinematic Universe (MCU). It was directed by Anthony and Joe Russo and written by Christopher Markus and Stephen McFeely, and features an ensemble cast including Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth, Scarlett Johansson, Jeremy Renner, Don Cheadle, Paul Rudd, Brie Larson, Karen Gillan, Danai Gurira, Benedict Wong, Jon Favreau, Bradley Cooper, Gwyneth Paltrow, and Josh Brolin. In the film, the surviving members of the Avengers and their allies attempt to reverse the damage caused by Thanos in Infinity War."
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
