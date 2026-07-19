
import java.io.RandomAccessFile;

public class ReaderBST {

    class Node {

        Reader data;
        Node left, right;

        Node(Reader data) {
            this.data = data;
        }
    }

    Node root;

    public void ftraverse(RandomAccessFile f, Node root) throws Exception {
        if (root == null) {
            return;
        }
        this.ftraverse(f, root.left);
        f.writeBytes("(" + root.data.id + "," + root.data.name + ")");
        this.ftraverse(f, root.right);
    }

    public void ftraverse(RandomAccessFile f) throws Exception {
        if (root == null) {
            f.writeBytes("Empty\r\n");
            return;
        }
        this.ftraverse(f, root);
    }

    public void insert(Reader r) {
        // ---------- Student's code starts from here ----------
        // Students are welcomed to use any helper function(s)
        if (root == null) {
            root = new Node(r);
            return;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            parent = cur;
            int cmp = r.id.compareTo(cur.data.id);
            if (cmp < 0) {
                cur = cur.left;
            } else if (cmp > 0) {
                cur = cur.right;
            } else {
                return;
            }
        }
        int cmp = r.id.compareTo(parent.data.id);
        if (cmp < 0) {
            parent.left = new Node(r);
        } else {
            parent.right = new Node(r);
        }
        // -----------------------------------------------------
    }

    public int countGreater(String id) {
        int c = 0;
        // ---------- Student's code starts from here ----------
        // Students are welcomed to use any helper function(s)
        Node[] stack = new Node[1000]; 
        int top = -1;
        Node cur = root;
        
        while (cur != null || top >= 0) {
            while (cur != null) {
                stack[++top] = cur;
                cur = cur.left;
            }
            cur = stack[top--];
            if (cur.data.id.compareTo(id) > 0) {
                c++;
            }
            cur = cur.right;
        }
        // -----------------------------------------------------
        return c;
    }
}
