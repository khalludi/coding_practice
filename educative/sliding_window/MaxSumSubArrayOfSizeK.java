class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int result = Integer.MIN_VALUE;
    int startWindow = 0;
    int sum = 0;
    for (int endWindow = 0; endWindow < arr.length; endWindow++) {
      sum += arr[endWindow];

      if (endWindow >= k - 1) {
        if (sum > result)
          result = sum;
        sum = sum - arr[startWindow];
        startWindow++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
  }
}
