class Solution {
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        if (s.length() < 1) return "";
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandCenters(s, i, i);
            int len2 = expandCenters(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) /2;
                end = i + len/2;
            } 
        }
        
        return s.substring(start, end+1);
    }
    
    private static int expandCenters(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main (String[] args) {
        System.out.println(longestPalindrome("ababd"));
    }
}
