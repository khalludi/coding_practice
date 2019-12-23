import java.util.ArrayList;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int startWindow = 0;
        ArrayList<Character> arr = new ArrayList<>();
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char rightChar = s.charAt(endWindow);
            
            while(arr.contains(rightChar)) {
                arr.remove(0);
                startWindow++;
            }
            arr.add(arr.size(), rightChar);
            ret = Math.max(ret, endWindow - startWindow + 1);
        }
        
        return ret;
    }
}
