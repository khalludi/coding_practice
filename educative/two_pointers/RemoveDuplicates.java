class RemoveDuplicates {

  public static int remove(int[] arr) {
    // TODO: Write your code here
    int startPtr = 0;
    for (int endPtr = 0; endPtr < arr.length - 1; endPtr++) {
      if (arr[endPtr+1] != arr[endPtr]) {
        arr[startPtr] = arr[endPtr];
        startPtr++;
      }
    }

    return startPtr + 1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
    System.out.println(RemoveDuplicates.remove(arr));

    arr = new int[] { 2, 2, 2, 11 };
    System.out.println(RemoveDuplicates.remove(arr));
  }
}
