import java.util.*;

class WordConcatenation {
  public static List<Integer> findWordConcatenation(String str, String[] words) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    
    int wordLength = 0;
    HashMap<String, Integer> wordsFreq = new HashMap<>();
    for(String word : words) {
      wordsFreq.put(word, wordsFreq.getOrDefault(word, 0) + 1);
      wordLength += word.length();
    }

    
    for (int i = 0; i < str.length() - wordLength + 1; i++) {
      HashMap<String, Integer> seenWords = new HashMap<>();
      int index = i;
      for (int j = 0; j < words.length; j++) {
        String sampleWord = str.substring(index, index + words[j].length());
        System.out.println(sampleWord);

        seenWords.put(sampleWord, seenWords.getOrDefault(sampleWord, 0) + 1);

        if (seenWords.get(sampleWord) > wordsFreq.getOrDefault(sampleWord, 0)) {
          break;
        } 

        if (j + 1 == words.length) {
          resultIndices.add(i);
        }

        index += words[j].length();
      }
    }

    return resultIndices;
  }

  public static void main(String[] args) {
    List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
    System.out.println(result);
    result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
    System.out.println(result);
  }
}

