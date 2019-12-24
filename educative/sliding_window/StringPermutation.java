import java.util.*;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    int startWindow = 0;
    HashMap<Character, Integer> patternMap = new HashMap<>();
    HashMap<Character, Integer> freqMap = new HashMap<>();

    for (int i = 0; i < pattern.length(); i++) {
      patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0) + 1);
    }

    for (int endWindow = 0; endWindow < str.length(); endWindow++) {
      char rightChar = str.charAt(endWindow);
      freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
      
      while (freqMap.getOrDefault(rightChar, 0) > patternMap.getOrDefault(rightChar, 0)) {
        char leftChar = str.charAt(startWindow);
        freqMap.put(leftChar, freqMap.get(leftChar) - 1);

        if (freqMap.get(leftChar) <= 0) {
          freqMap.remove(leftChar);
        }

        startWindow++;
      }

      if (endWindow - startWindow + 1 == pattern.length()) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(findPermutation("oidbcaf", "abc"));
    
  }
}

