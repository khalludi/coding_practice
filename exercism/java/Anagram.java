import java.util.*;
import java.util.stream.*;

public class Anagram {
  private ArrayList<String> baseWord;
  private String baseWordStr;
  
  public Anagram(String baseWord) {
    this.baseWord = new ArrayList<>(Arrays.asList(baseWord.split("")));
    this.baseWordStr = baseWord;
  }

  public List<String> match(List<String> words) {
    return words.stream()
              .filter(word -> unEqual(word) && isAnagram(word))
              .collect(Collectors.toList());
  }

  private boolean isAnagram(String word) {
    ArrayList<String> tmpWord = (ArrayList) baseWord.clone();

    ArrayList<String> wordArr = new ArrayList<>(Arrays.asList(word.split("")));
    
    wordArr.removeIf(x -> tmpWord.remove(x.toLowerCase()) || tmpWord.remove(x.toUpperCase()));
    
    return tmpWord.isEmpty() && wordArr.isEmpty();
  }

  private boolean unEqual(String word) {
    return !baseWordStr.toLowerCase().equals(word.toLowerCase());
  }
}
