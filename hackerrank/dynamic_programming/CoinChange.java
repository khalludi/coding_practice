/*

Hackerrank "The Coin Change Problem"
https://www.hackerrank.com/challenges/coin-change/problem

*/

import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// Dynamic Programming Bottom Up approach - way too slow for large values
public class CoinChange {

    // Complete the getWays function below.
    static long getWays(long sum, long[] coins) {

        // Create Memoization Table for "Bottom-Up" approach
        HashMap<Integer, HashSet<ArrayList<Integer>>> memo = new HashMap<Integer, HashSet<ArrayList<Integer>>>();

        // Creating a set to keep combinations without duplicates
        HashSet<ArrayList<Integer>> combinations = new HashSet<ArrayList<Integer>>();

        // Initialize empty zero element in table
        ArrayList<Integer> zero = new ArrayList<Integer>();
        combinations.add(zero);
        memo.put(0, combinations);

        // Calculate every possible combination until sum is reached
        for(int i = 1; i <= sum+1; i++) {
            combinations = new HashSet<ArrayList<Integer>>();
            for (int j = 0; j < coins.length; j++) {
                // If the coin is equal to the sum, i
                if (coins[j] == i) {
                    // Add the coin into possible combinations
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(i);
                    combinations.add(a);
                }
                else if (coins[j] < i) {
                    // Debug print statements:
                    //System.out.println("Map Index: " + (i - coins[j]) + ", Sum: " + i);
                    //System.out.println(memo);
                    //System.out.println(memo.get(i - (int)coins[j]));

                    // Get the coin combos
                    HashSet<ArrayList<Integer>> one_coinset = memo.get(i - (int)coins[j]);
                    Iterator iter = one_coinset.iterator();
                    while(iter.hasNext()) {
                        // Create a copy of the combination to avoid changing the old one
                        @SuppressWarnings("unchecked")
                        ArrayList<Integer> tmp = (ArrayList<Integer>)((ArrayList<Integer>) iter.next()).clone();

                        // Binary Search to keep sorted combos so HashSet can remove duplicates
                        int index = binarySearch(tmp, (int)coins[j], 0, tmp.size() - 1);
                        tmp.add(index, (int)coins[j]);
                        combinations.add(tmp);
                    }
                }
            }
            // Add the combinations of i into the memo table
            memo.put(i, combinations);
        }
        // Return the total number of combinations
        return memo.get((int)sum).size();
    }

    // Reimplemented binarySearch for practice
    static int binarySearch(ArrayList<Integer> arr, int num, int low, int high) {

        if (high <= low) {
            if (num > arr.get(low)) {
                return low + 1;
            } else {
                return low;
            }
        }

        int mid = (high + low)/2;

        if (num == arr.get(mid)) {
            return mid;
        } else if (num > arr.get(mid)) {
            return binarySearch(arr, num, mid + 1, high);
        } else {
            return binarySearch(arr, num, low, mid - 1);
        }
    }

    public static void main(String args[]) {

        long[] coins = {8,47,13,24,25,31,32,35,3,19,40,48,1,4,17,38,22,30,33,15,44,46,36,9,20,9};
        long sum = 250;

        System.out.println("Coin Change!");
        System.out.println(getWays(sum, coins));
    }
}
