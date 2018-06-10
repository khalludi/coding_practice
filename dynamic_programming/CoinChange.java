/*

Hackerrank "The Coin Change Problem"
https://www.hackerrank.com/challenges/coin-change/problem

*/

public class CoinChange {

    // Complete the getWays function below.
    static long getWays(long sum, long[] coins) {

        long[][] min = new long[sum+1][2];
        min[0] = [0,0];

        for(int i = 1; i < min.length; i++) {
            min[i] = [Long.MAX_VALUE, 0];
        }

        for(int i=1; i <= sum; i++) {
            for (int j=0; j < coins.length; j++) {
                if (coins[j] <= i && min[i-coins[j]] + 1 < min[i]) {
                    min[i][0] = min[i - coins[j]] + 1;
                    min[i][1] += 1;
                }
            }
        }

        return min[sum][1];
    }

    public static void main(String args[]) {

        int[] coins = {1,3,5};
        int sum = 11;

        System.out.println("Coin Change!");

        for(int i : min) {
            System.out.print(i + ", ");
        }

        System.out.println();
    }
}
