/*

LeetCode "Reverse Integer"
https://www.hackerrank.com/challenges/coin-change/problem

*/

public class ReverseInteger {

    static int reverse(int x) {
        return ~x;
    }

    public static void main(String args[]) {
        System.out.println("Reverse Integer!\n" + reverse(8));
    }
}
