import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange2 {

    long[][] memo = new long[n][c.length];

    static long getWays(long n, long[] c) {

        for (long[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return memo.get((int)n);
    }

    static long count(long sum, long[] coins) {
        
    }

    public static void main(String args[]) {

        long[] coins = {1,2,3};
        long sum = 4;

        System.out.println("Coin Change!");

        System.out.printf("%d ways", getWays(sum, coins));
    }
}
