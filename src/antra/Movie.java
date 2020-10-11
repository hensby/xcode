package antra;

public class Movie implements Comparable<Movie> {

    String name;
    String author;
    int year;
    String Type;

    Movie(String name, String author, int year, String type) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.Type = type;
    }

    Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public int compareTo(Movie o) {
        if(this.year == o.year) return 0;
        else if(this.year < o.year) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
