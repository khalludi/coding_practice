
class BackspaceCompare {

  public static boolean compare(String str1, String str2) {
    int index1 = str1.length() - 1, index2 = str2.length() - 1;
    while (index1 >= 0 && index2 >= 0) {
      int c1 = getValidCharacterIndex(str1, index1);
      int c2 = getValidCharacterIndex(str2, index2);

      if (c1 < 0 && c2 < 0) {
        return true;
      }

      if (c1 >= 0 && c2 >= 0) {
        if (str1.charAt(c1) == str2.charAt(c2)) {
          index1 = c1 - 1;
          index2 = c2 - 1;
          continue;
        }
      }

      return false;
    }

    return true;
  }

  private static int getValidCharacterIndex(String str, int idx) {
    int bkspc = 0;
    char c = str.charAt(idx);
    int tmp_idx = idx;
    while(c == '#') {
      c = str.charAt(--tmp_idx);
      bkspc++;
    }
    return tmp_idx - bkspc;
  }

  public static void main(String[] args) {
    System.out.println(BackspaceCompare.compare("xy#z", "xzz#")); // should be true
    System.out.println(BackspaceCompare.compare("xy#z", "xyz#")); // should be false
    System.out.println(BackspaceCompare.compare("xp#", "xyz##")); // should be true
    System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p")); // should be true
  }
}

