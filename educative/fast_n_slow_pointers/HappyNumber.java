class HappyNumber {

  public static boolean find(int num) {
    int slowPtr = num;
    int fastPtr = num;
    while (fastPtr != 1) {
      slowPtr = computeNext(slowPtr);
      fastPtr = computeNext(computeNext(fastPtr));

      if (slowPtr == fastPtr) {
        return true;
      }
    }

    return false;
  }

  private static int computeNext(int num) {
    int sum = 0;
    while (num > 0) {
      int x = num % 10;
      sum += x * x;
      num /= 10;
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(HappyNumber.find(23));
    System.out.println(HappyNumber.find(12));
  }
}
