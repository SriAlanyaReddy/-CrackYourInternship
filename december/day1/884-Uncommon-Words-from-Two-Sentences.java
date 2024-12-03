import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Split the sentences into words
        String[] words1 = s1.split("\\s");
        String[] words2 = s2.split("\\s");
        
        // Use a HashMap to count occurrences of each word
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Count words from the first sentence
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Count words from the second sentence
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Collect words that appear exactly once
        List<String> uncommonWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                uncommonWords.add(entry.getKey());
            }
        }
        
        // Convert the list of uncommon words to an array and return
        return uncommonWords.toArray(new String[0]);
    }
}
