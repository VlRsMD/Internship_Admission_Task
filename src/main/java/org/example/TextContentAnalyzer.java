package org.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextContentAnalyzer {
    public int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    public int countSentences(String text) {
        String[] sentences = text.split("[.!?]");
        return sentences.length;
    }

    public List<String> getPhrases(String text, int phraseSize) {
        String[] words = text.split("\\s+");
        List<String> phrases = new ArrayList<>();
        for (int i = 0; i <= words.length - phraseSize; i++) {
            StringBuilder phrase = new StringBuilder();
            for (int j = 0; j < phraseSize; j++) {
                phrase.append(words[i + j]);
                if (j < phraseSize - 1) {
                    phrase.append(" ");
                }
            }
            phrases.add(phrase.toString());
        }
        return phrases;
    }

    public Map<String, Long> getFrequency(List<String> items) {
        return items.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    public Map<String, Long> getTopEntries(Map<String, Long> frequencyMap, int top) {
        return frequencyMap.entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(top)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
