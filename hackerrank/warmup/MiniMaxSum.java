import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        long max = 0;
        long min = Long.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            long tmp1 = 0;
            for (int j = 0; j < arr.length; j++)  {
                if (i == j) {
                    continue;
                } else {
                    tmp1 += arr[j];
                }
            }
            if (max < tmp1) {
                max = tmp1;
            }
            if (min > tmp1) {
                min = tmp1;
            }
        }

        System.out.println(min + " " + max);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
