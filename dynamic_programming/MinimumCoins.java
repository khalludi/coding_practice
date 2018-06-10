/*

Given a list of N coins, their values (V1, V2, … , VN), and the total sum S.
Find the minimum number of coins the sum of which is S
(we can use as many coins of one type as we want),
or report that it’s not possible to select coins in such a way that they sum up to S.

*/

public class MinimumCoins {

    public static void main(String args[]) {

        int[] coins = {1,3,5};
        int sum = 11;

        int[] min = new int[sum+1];
        min[0] = 0;

        for(int i = 1; i < min.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }

        for(int i=1; i <= sum; i++) {
            for (int j=0; j < coins.length; j++) {
                if (coins[j] <= i && min[i-coins[j]] + 1 < min[i]) {
                    min[i] = min[i - coins[j]] + 1;
                }
            }
        }

        System.out.println("Minimum Coins!");

        for(int i : min) {
            System.out.print(i + ", ");
        }

        System.out.println();
    }
}
