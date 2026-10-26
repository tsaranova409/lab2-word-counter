package ua.kpi.comsys.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordCounter {

    public Map<String, Integer> countWords(List<String> textLines) {
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String line : textLines) {
            String[] words = line.toLowerCase().split("[^a-z0-9]+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCounts.put(
                            word,
                            wordCounts.getOrDefault(word, 0) + 1
                    );
                }
            }
        }

        return wordCounts;
    }

    public Set<String> getUniqueWords(List<String> textLines) {
        Set<String> uniqueWords = new HashSet<>();

        for (String line : textLines) {
            String[] words = line.toLowerCase().split("[^a-z0-9]+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    uniqueWords.add(word);
                }
            }
        }

        return uniqueWords;
    }
}
