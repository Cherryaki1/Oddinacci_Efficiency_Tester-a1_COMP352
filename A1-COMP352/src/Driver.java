//Botao Yang (40213554) and Valerie Nguyen (40284261)
//Programming Assignment 1
//COMP 352 AA
//Due May 24, 2024

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Driver {
    public static void main(String[] args) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("OddoOut.txt", true));
            //writing runtime performance in nanoseconds of linear recursion from 5 to 200 in increments of 5
            for (int n = 5; n <= 200; n += 5) {
                long startTime = System.nanoTime();
                double[] a = linearOdd(n);
                long endTime  = System.nanoTime();
                pw.write("linearOdd(" + n  + ") is " + a[0] + ". The runtime is " + (endTime - startTime) + " nanoseconds.\n");
            }
            System.out.println("");
            //writing runtime performance in nanoseconds of multiple recursion from 1 to 40 in increments of 1
            for (int n = 1; n <=40; n++) {
                long startTime = System.nanoTime();
                double a = multipleOdd(n);
                long endTime  = System.nanoTime();
                pw.write("multipleOdd(" + n  + ") is " + a + ". The runtime is " + (endTime - startTime) + " nanoseconds.\n");
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File could not be opened.");
        }

    }

    // Multiple Recursion
    public static double multipleOdd(int n) { 
        if (n <= 3) { //base case: if n is less than 3, return the first three predetermined values
            return 1;
        } else { //recursive call: sum of the three previous Oddonacci numbers Fn-1, Fn-2 and Fn-3
            return multipleOdd(n - 1) + multipleOdd(n - 2) + multipleOdd(n - 3);
        }
    }

    // Linear Recursion
    public static double[] linearOdd(int n) {
        double[] a = new double[3]; //array to store Oddonacci numbers
        double i = 0, j = 0, k = 0;
        if (n <= 3) { //base case: if n is less than three, return array with the first three predetermined values
            a[0] = 1;
            a[1] = 1;
            a[2] = 1;
            return a;
        } else { //shift the values in the array to the next Oddonacci number where a[0] is i+j+k (the next Oddonacci number), a[1] is i and a[0] is j
            a = linearOdd(n - 1); //to find the previous Oddonacci numbers
            i = a[0]; 
            j = a[1];
            k = a[2];
            a[0] = i + j + k;
            a[1] = i;
            a[2] = j;
            return a;
        }
    }

    // Tail Recursion
    public static int tailOdd(int n, int i, int j, int k) { //i, j and k are Oddonacci numbers
        //base cases: if n is less than three, return the first, second or third Oddonacci number
        if (n == 1) {
            return i;
        } else if (n == 2) {
            return j;
        } else if (n == 3) {
            return k;
        } else {
            return tailOdd(n - 1, j, k, i+j+k); //recursive call: shift all parameters to the next Oddonacci number
                                                //i becomes j, j becomes k, and k becomes i, j, k (the next Oddonacci number)
        }
    }

}
