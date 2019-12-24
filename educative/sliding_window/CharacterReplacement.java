import java.util.*;

class CharacterReplacement {
  public static int findLength(String str, int k) {
    // TODO: Write your code here
    int startWindow = 0;
    int maxLength = 0;
    int maxRepeatingChars = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int endWindow = 0; endWindow < str.length(); endWindow++) {
      char rightChar = str.charAt(endWindow);
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
      maxRepeatingChars = Math.max(maxRepeatingChars, map.get(rightChar));
      
      if (endWindow - startWindow + 1 - maxRepeatingChars > k) {
        char leftChar = str.charAt(startWindow);
        map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
        startWindow++;
      }

      maxLength = Math.max(maxLength, endWindow - startWindow + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(CharacterReplacement.findLength("aabccbb", 2));
    System.out.println(CharacterReplacement.findLength("abbcb", 1));
    System.out.println(CharacterReplacement.findLength("abccde", 1));
  }
}

