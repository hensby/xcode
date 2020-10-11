package antra;

public class Show {
    String name;
    String author;
    int year;
    String Type;

    Show(String name, String author, int year, String type) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.Type = type;
    }

    Show(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Show{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
