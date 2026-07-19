public class Reader {
    String id;
    String name;

    public Reader(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " " + name;
    }
}