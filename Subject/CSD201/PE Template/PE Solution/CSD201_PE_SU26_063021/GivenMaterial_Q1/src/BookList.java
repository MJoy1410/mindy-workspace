
import java.io.RandomAccessFile;

public class BookList {

    class Node {

        Book data;
        Node next;

        Node(Book data) {
            this.data = data;
        }
    }

    Node head;

    public void ftraverse(RandomAccessFile f) throws Exception {
        if (head == null) {
            f.writeBytes("Empty\r\n");
            return;
        }
        Node cur = head;
        while (cur != null) {
            f.writeBytes("(" + cur.data.id + "," + cur.data.title + "," + cur.data.year + ")");
            cur = cur.next;
        }
    }

    public void add(Book b) {
        if (head == null) {
            head = new Node(b);
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(b);
    }

    public int count() {
        int c = 0;
        // ---------- Student's code starts from here ----------
        // Students are welcomed to use any helper function(s)
        Node cur = head;
        while (cur != null) {
            c++;
            cur = cur.next;
        }
        // -----------------------------------------------------
        return c;
    }

    public BookList printAfter(int year) {
        BookList result = new BookList();
        // ---------- Student's code starts from here ----------
        // Students are welcomed to use any helper function(s)
        Node cur = head;
        while (cur != null) {
            if (cur.data.year > year) {
                result.add(cur.data);
            }
            cur = cur.next;
        }
        // -----------------------------------------------------
        return result;
    }
}
