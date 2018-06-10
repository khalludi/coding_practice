import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange2 {

    static long getWays(long n, long[] c) {

        ArrayList<Long> memo = new ArrayList<Long>();
        memo.add((long) 0 );

        for (int i = 1; i <= n; i++) {
            memo.add((long) 0);
            for (int j = 0; j < c.length; j++) {
                if (i - c[j] >= 0 && memo.get(i - (int)c[j]) + 1 < memo.get(i)) {
                    memo.set(i, memo.get(i - (int)c[j]) + 1);
                }
                System.out.println(Arrays.toString(memo.toArray()));
            }
        }

        return memo.get((int)n);
    }

    public static void main(String args[]) {

        long[] coins = {1,2,3};
        long sum = 4;

        System.out.println("Coin Change!");

        System.out.printf("%d ways", getWays(sum, coins));
    }
}
