import java.io.File;
import java.io.RandomAccessFile;

public class Assignment {
    BookList bl;
    ReaderBST bst;
    String dataFile = "data.txt";

    public Assignment() {
        bl = new BookList();
        bst = new ReaderBST();
    }

    public void loadDataBook() {
        String[] ids   = Lib.readLineToStrArray(dataFile, 1);
        String[] titles = Lib.readLineToStrArray(dataFile, 2);
        int[] years    = Lib.readLineToIntArray(dataFile, 3);

        for (int i = 0; i < ids.length; i++) {
            bl.add(new Book(ids[i], titles[i], years[i]));
        }
    }

    public void loadDataReader() {
        String[] ids   = Lib.readLineToStrArray(dataFile, 5);
        String[] names = Lib.readLineToStrArray(dataFile, 6);

        for (int i = 0; i < ids.length; i++) {
            bst.insert(new Reader(ids[i], names[i]));
        }
    }

    public void f1() throws Exception {
        String fname = "f1.txt";
        File f = new File(fname);
        if (f.exists()) f.delete();
        RandomAccessFile rf = new RandomAccessFile(fname, "rw");
        loadDataBook();
        rf.writeBytes("Current Books:\r\n");
        bl.ftraverse(rf);
        int count = bl.count();
        rf.writeBytes("\r\nTotal books: " + count + "\r\n");
        rf.close();
    }

    public void f2() throws Exception {
        String fname = "f2.txt";
        File f = new File(fname);
        if (f.exists()) f.delete();
        RandomAccessFile rf = new RandomAccessFile(fname, "rw");
        loadDataBook();
        int compareYear = Integer.parseInt(Lib.readLineToStr(dataFile, 7));
        rf.writeBytes("Current Books:\r\n");
        bl.ftraverse(rf);
        rf.writeBytes("\r\nListing books published after " + compareYear + ":\r\n");
        BookList filteredBooks = bl.printAfter(compareYear);
        filteredBooks.ftraverse(rf);
        rf.close();
    }

    public void f3() throws Exception {
        String fname = "f3.txt";
        File f = new File(fname);
        if (f.exists()) f.delete();
        RandomAccessFile rf = new RandomAccessFile(fname, "rw");
        rf.writeBytes("Current Readers (Alphabetically Ordered by ID):\r\n");
        loadDataReader();
        bst.ftraverse(rf);
        rf.close();
    }

    public void f4() throws Exception {
        String fname = "f4.txt";
        File f = new File(fname);
        if (f.exists()) f.delete();
        RandomAccessFile rf = new RandomAccessFile(fname, "rw");
        rf.writeBytes("Current Readers:\r\n");
        loadDataReader();
        bst.ftraverse(rf);
        String compareID = Lib.readLineToStr(dataFile, 8);
        rf.writeBytes("\r\nCounting readers with ID > " + compareID + ":");
        int result = bst.countGreater(compareID);
        rf.writeBytes("\r\nResult: " + result);
        rf.close();
    }
}