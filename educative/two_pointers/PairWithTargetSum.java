class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    // TODO: Write your code here
    int endPtr = arr.length - 1;
    for(int startPtr = 0; startPtr < arr.length && startPtr != endPtr;) {
      if (arr[startPtr] + arr[endPtr] > targetSum) {
        endPtr--;
      } else if (arr[startPtr] + arr[endPtr] < targetSum) {
        startPtr++;
      } else {
        return new int[] { startPtr, endPtr };
      }
    }

    return new int[2];
  }

  public static void main(String[] args) {
    int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
  }
}
