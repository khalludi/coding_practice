import java.util.*;

class QuadrupleSumToTarget {

  public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
    List<List<Integer>> quadruplets = new ArrayList<>();
    
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 4; i++) {
      for (int j = i+1; j < arr.length - 3; j++) {
        int left = j+1, right = arr.length - 1;
        while (left < right) {
          int currSum = arr[i] + arr[j] + arr[left] + arr[right];
          if (currSum == target) {
            List<Integer> tempSum = new LinkedList<Integer>();
            tempSum.add(arr[i]);
            tempSum.add(arr[j]);
            tempSum.add(arr[left]);
            tempSum.add(arr[right]);
            quadruplets.add(tempSum);
            left++;
            right--;
            while(left < right && arr[left] == arr[left-1]) {
              left++;
            }
            while(left < right && arr[right] == arr[right+1]) {
              right--;
            }
          } else if (currSum > target) {
            right--;
          } else {
            left++;
          }
        }
      }
    }

    return quadruplets;
  }

  public static void main(String[] args) {
    System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
    System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
  }
}
