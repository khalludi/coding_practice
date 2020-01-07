class ShortestWindowSort {

  public static int sort(int[] arr) {
    int max = arr[0];
    int min = arr[0];
    int start = -1;
    int end = -1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max)
        max = arr[i];
      else if (arr[i] < max) {
        if (start == -1)
          start = i - 1;
        if (arr[i] < min) {
          start = 0;
        }
        end = i;
      }
    }
    if (end == -1) {
      end = -2;
    }
    return end - start + 1;
  }
}
