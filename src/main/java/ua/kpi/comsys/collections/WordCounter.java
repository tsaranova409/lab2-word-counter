package ua.kpi.comsys.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class WordCounter {

    public Map<String, Integer> countWords(List<String> textLines) {
        if (textLines == null) {
            throw new IllegalArgumentException("textLines cannot be null");
        }

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String line : textLines) {
            List<String> words = extractWords(line);

            for (String word : words) {
                wordCounts.put(
                        word,
                        wordCounts.getOrDefault(word, 0) + 1
                );
            }
        }

        return wordCounts;
    }

    public Set<String> getUniqueWords(List<String> textLines) {
        if (textLines == null) {
            throw new IllegalArgumentException("textLines cannot be null");
        }

        Set<String> uniqueWords = new HashSet<>();

        for (String line : textLines) {
            List<String> words = extractWords(line);
            uniqueWords.addAll(words);
        }

        return uniqueWords;
    }

    private List<String> extractWords(String line) {
        List<String> words = new ArrayList<>();

        if (line == null || line.isEmpty()) {
            return words;
        }

        String[] parts = line.toLowerCase(Locale.ROOT)
                .split("[^a-z0-9]+");

        for (String part : parts) {
            if (!part.isEmpty()) {
                words.add(part);
            }
        }

        return words;
    }
}
