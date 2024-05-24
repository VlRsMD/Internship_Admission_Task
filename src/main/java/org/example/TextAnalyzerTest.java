package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextAnalyzerTest {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Lorem ipsum dolor sit amet. Lorem ipsum dolor sit. " +
            "Aenean commodo ligula eget dolor. Aenean massa.";
    List<String> phrases = textContentAnalyzer.getPhrases(SAMPLE_TEXT, 3);
    static TextContentAnalyzer textContentAnalyzer = new TextContentAnalyzer();

    @Test
    public void testCountWords() {
        int wordCount = textContentAnalyzer.countWords(SAMPLE_TEXT);
        assertEquals(24, wordCount);
    }

    @Test
    public void testCountSentences() {
        int sentenceCount = textContentAnalyzer.countSentences(SAMPLE_TEXT);
        assertEquals(5, sentenceCount);
    }

    @Test
    public void testGetPhrases() {
        assertEquals(22, phrases.size());  // Corrected expected value
        assertTrue(phrases.contains("Lorem ipsum dolor"));
    }

    @Test
    public void testGetFrequency() {
        Map<String, Long> frequency = textContentAnalyzer.getFrequency(phrases);
        assertEquals(3, (long) frequency.get("Lorem ipsum dolor"));
        assertEquals(2, (long) frequency.get("ipsum dolor sit"));
    }

    @Test
    public void testGetTopEntries() {
        List<String> phrases = textContentAnalyzer.getPhrases(SAMPLE_TEXT, 3);
        Map<String, Long> frequency = textContentAnalyzer.getFrequency(phrases);
        Map<String, Long> topEntries = textContentAnalyzer.getTopEntries(frequency, 2);
        assertEquals(2, topEntries.size());
        assertTrue(topEntries.containsKey("Lorem ipsum dolor"));
        assertTrue(topEntries.containsKey("ipsum dolor sit"));
    }
}