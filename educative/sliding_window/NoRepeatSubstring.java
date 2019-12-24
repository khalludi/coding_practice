import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    // TODO: Write your code here
    int startWindow = 0;
    int retLength = 0;
    ArrayList<Character> arr = new ArrayList<>();
    for (int endWindow = 0; endWindow < str.length(); endWindow++) {
      char newChar = str.charAt(endWindow);
      while(arr.contains(newChar)) {
        arr.remove(0);
        startWindow++;
      }
      arr.add(newChar);
      retLength = Math.max(retLength, endWindow - startWindow + 1);
    }
    return retLength;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
  }
}
