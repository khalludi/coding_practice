class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];
    // TODO: Write your code here
    int startPtr = 0;
    int endPtr = arr.length - 1;
    for (int i = arr.length - 1; i >= 0; i--) {
      int left = arr[startPtr] * arr[startPtr];
      int right = arr[endPtr] * arr[endPtr];
      if (left > right) {
        squares[i] = left;
        startPtr++;
      } else {
        squares[i] = right;
        endPtr--;
      }
    }

    return squares;
  }

  public static void main(String[] args) {

    int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();

    result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();
  }
}
