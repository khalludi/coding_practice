/*

Hackerrank "Grading Students"
https://www.hackerrank.com/challenges/grading/problem

Test Input:
4
73
67
38
33

Test Output:
75
67
40
33

*/
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class GradingStudents {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        int[] ret = new int[grades.length];
        for(int i = 0; i < grades.length; i++) {
            if (grades[i] % 5 >= 3 && grades[i] >= 38) {
                ret[i] = grades[i] + (5 - (grades[i] % 5));
            } else {
                ret[i] = grades[i];
            }
        }

        return ret;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(String.valueOf(result[resultItr]));
        }
    }
}
