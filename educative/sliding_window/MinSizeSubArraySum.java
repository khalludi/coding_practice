class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int resultLength = Integer.MAX_VALUE;
    int startWindow = 0;
    int sum = 0;
    for (int endWindow = 0; endWindow < arr.length; endWindow++) {
      sum += arr[endWindow];

      while (sum >= S) {
        resultLength = Math.min(resultLength, endWindow - startWindow + 1);
        sum -= arr[startWindow];
        startWindow++;
      }
    }
    return resultLength;
  }

  public static void main(String[] args) {
    int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("Smallest subarray length: " + result);
  }
}

