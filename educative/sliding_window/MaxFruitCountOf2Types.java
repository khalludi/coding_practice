import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    // TODO: Write your code here
    int startWindow = 0;
    int ret = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int endWindow = 0; endWindow < arr.length; endWindow++) {
      char rightChar = arr[endWindow];
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
      
      while (map.size() > 2) {
        char leftChar = arr[startWindow];
        map.put(leftChar, map.get(leftChar) - 1);
        if (map.get(leftChar) == 0) {
          map.remove(leftChar);
        }
        startWindow++;
      }
      
      ret = Math.max(ret, endWindow - startWindow + 1);
    }
    
    return ret;
  }
}

