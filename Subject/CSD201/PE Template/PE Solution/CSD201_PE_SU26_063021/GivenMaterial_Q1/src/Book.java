public class Book {
    String id;
    String title;
    int year;

    public Book(String id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public String toString() {
        return id + " " + title + " " + year;
    }
}