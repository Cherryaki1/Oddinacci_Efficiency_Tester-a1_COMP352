import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Driver {
    public static void main(String[] args) {
        // System.out.println(multipleOdd(10));
        // int[] a = linearOdd(10);
        // System.out.println(a[0]);
        System.out.println(tailOdd(10, 1, 1, 1));
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("OddoOut.txt", true));
            long start = System.nanoTime();
            for (int i = 5; i < 200; i += 5) {
                linearOdd(i);
            }
            long end = System.nanoTime();
            pw.write("Time taken for Linear Recursion: " + (end - start) + "\n");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File could not be opened.");
        }

    }

    public static int multipleOdd(int n) {
        if (n <= 3) {
            return 1;
        } else {
            return multipleOdd(n - 1) + multipleOdd(n - 2) + multipleOdd(n - 3);
        }
    }

    public static int[] linearOdd(int n) {
        int[] a = new int[3];
        int i = 0, j = 0, k = 0;
        if (n <= 3) {
            a[0] = 1;
            a[1] = 1;
            a[2] = 1;
            return a;
        } else {
            a = linearOdd(n - 1);
            i = a[0];
            j = a[1];
            k = a[2];
            a[0] = i + j + k;
            a[1] = i;
            a[2] = j;
            return a;
        }
    }

    // question c
    public static int tailOdd(int n, int i, int j, int k) {
        if (n == 1) {
            return i;
        } else if (n == 2) {
            return j;
        } else if (n == 3) {
            return k;
        } else {
            return tailOdd(n - 1, j, k, i+j+k);
        }
    }

}
