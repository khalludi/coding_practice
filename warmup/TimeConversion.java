/*

Hackerrank "Time Conversion"
https://www.hackerrank.com/challenges/time-conversion/

Test Input:
07:05:45PM

Test Output:
19:05:45

*/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        if (s.charAt(8) == 'A') {
            if (s.substring(0,2).equals("12")) {
                return "00" + s.substring(2,8);
            } else {
                return s.substring(0, 8);
            }
        } else {
            if (s.substring(0,2).equals("12")) {
                return "12" + s.substring(2,8);
            } else {
                int hour = Integer.valueOf(s.substring(0,2)) + 12;
                return hour + s.substring(2,8);
            }
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scan.nextLine();

        String result = timeConversion(s);

        System.out.println(result);
        scan.close();
    }
}
