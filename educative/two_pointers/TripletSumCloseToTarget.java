import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    Arrays.sort(arr);
    int diff = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length-2; i++) {
      int left = i + 1, right = arr.length - 1;
      while (left < right) {
        int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
        if (targetDiff == 0) {
          return targetSum;
        }

        if (Math.abs(targetDiff) < Math.abs(diff)) {
          diff = targetDiff;
        }

        if (targetDiff > 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    return targetSum - diff;
  }
}
