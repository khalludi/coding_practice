/*

Hackerrank "Kangaroo"
https://www.hackerrank.com/challenges/kangaroo/problem

*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Kangaroo {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {

        // Same position
        if (x1 == x2) {
            return "YES";
        }

        int fast_x, slow_x, fast_v, slow_v;
        if (v1 > v2) {
            fast_x = x1;
            fast_v = v1;
            slow_x = x2;
            slow_v = v2;
        } else if (v1 < v2) {
            fast_x = x2;
            fast_v = v2;
            slow_x = x1;
            slow_v = v1;
        } else {
            return "NO";
        }

        while (fast_x < slow_x) {
            fast_x += fast_v;
            slow_x += slow_v;
            if (fast_x == slow_x) {
                return "YES";
            }
        }

        return "NO";

    }

}
