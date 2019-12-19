/*

Hackerrank "Apples and Oranges"
https://www.hackerrank.com/challenges/apple-and-orange/problem

*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AppleAndOrange {

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int ret_apples = 0;
        int ret_oranges = 0;
        for(int i = 0; i < apples.length; i++) {
            if (apples[i] + a >= s && apples[i] + a <= t) {
                ret_apples++;
            }
        }
        for(int i = 0; i < oranges.length; i++) {
            if (oranges[i] + b >= s && oranges[i] + b <= t) {
                ret_oranges++;
            }
        }

        System.out.print(ret_apples + "\n");
        System.out.printf("%d", ret_oranges);
    }
}
