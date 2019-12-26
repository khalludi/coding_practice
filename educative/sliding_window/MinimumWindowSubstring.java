import java.util.*;

class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern) {
    // TODO: Write your code here
    HashMap<Character, Integer> charFreq = new HashMap<>();
    for(char c : pattern.toCharArray()) {
      charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
    }

    String ret = "";
    int matched = 0;
    int startWindow = 0;
    for (int endWindow = 0; endWindow < str.length(); endWindow++) {
      char rightChar = str.charAt(endWindow);
      if (charFreq.containsKey(rightChar)) {
        charFreq.put(rightChar, charFreq.get(rightChar) - 1);
        if (charFreq.get(rightChar) == 0) {
          matched++;
        }
      }

      while (matched == pattern.length()) {
        if (ret.equals("") || endWindow - startWindow + 1 < ret.length()) {
          ret = str.substring(startWindow, endWindow + 1);
        }

        char leftChar = str.charAt(startWindow);
        if (charFreq.containsKey(leftChar)) {
          charFreq.put(leftChar, charFreq.get(leftChar) + 1);
          if (charFreq.get(leftChar) == 1) {
            matched--;
          }
        }
        startWindow++;
      } 
    }

    return ret;
  }
}

