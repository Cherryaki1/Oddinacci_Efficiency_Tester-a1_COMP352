public class Driver {
    public static void main(String[] args) {
        System.out.println(multipleOdd(10));
        int[] a = linearOdd(10);
        System.out.println(a[0]);
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

}
