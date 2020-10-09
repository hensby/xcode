package antra.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareEx {
    public static void main(String[] args) {

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("start war", 1999));
        movies.add(new Movie("start warIV", 2009));
        movies.add(new Movie("start warII", 2001));
        movies.add(new Movie("start warIII", 2005));

        Collections.sort(movies);
        System.out.println(movies);

        List<Show> shows = new ArrayList<>();
        shows.add(new Show("Romeo and JulietIII", 2007));
        shows.add(new Show("Romeo and Juliet", 1992));
        shows.add(new Show("Romeo and JulietII", 1999));
        shows.add(new Show("Romeo and JulietIV", 2009));

        Collections.sort(shows,new Comparator<Show>() {  // redesign Comparator
            @Override
            public int compare(Show o1, Show o2) {
                if(o1.year == o2.year) return 0;
                else if(o1.year < o2.year) return -1;
                else return 1;
            }
        });
        System.out.println(shows);
    }
}
