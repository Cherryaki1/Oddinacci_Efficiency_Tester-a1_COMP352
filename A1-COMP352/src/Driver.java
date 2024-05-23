import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Driver {
    public static void main(String[] args) {
        // System.out.println(multipleOdd(10));
        System.out.println(tailOdd(10, 1, 1, 1));
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("OddoOut.txt", true));
            for (int n = 5; n <= 200; n += 5) {
                long startTime = System.nanoTime();
                double[] a = linearOdd(n);
                long endTime  = System.nanoTime();
                pw.write("linearOdd(" + n  + ") is " + a[0] + ". The runtime is " + (endTime - startTime) + " nanoseconds.\n");
            }
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

    public static double[] linearOdd(int n) {
        double[] a = new double[3];
        double i = 0, j = 0, k = 0;
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
