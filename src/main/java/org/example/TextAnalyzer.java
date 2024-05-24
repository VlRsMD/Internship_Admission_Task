package org.example;

import java.util.*;

public class TextAnalyzer {

    static String filePath = "";
    static int top = 5;
    static int phraseSize = 3;
    static TextContentAnalyzer textContentAnalyzer = new TextContentAnalyzer();
    static FileContentReader fileContentReader = new FileContentReader();
    static ParameterValidityVerifier parameterValidityVerifier = new ParameterValidityVerifier();


    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.startsWith("-file=")) {
                filePath = arg.substring(6);
                parameterValidityVerifier.verifyFilePathValidityParameter(filePath);
            }
            if (arg.startsWith("-top=")) {
                top = Integer.parseInt(arg.substring(5));
                parameterValidityVerifier.verifyTopParameterValidity(top);
            } else if (arg.startsWith("-phraseSize=")) {
                phraseSize = Integer.parseInt(arg.substring(12));
                parameterValidityVerifier.verifyPhraseSizeParameterValidity(phraseSize);
            }
        }

        String text = fileContentReader.extractText(filePath);
        int wordCount = textContentAnalyzer.countWords(text);
        int sentenceCount = textContentAnalyzer.countSentences(text);
        List<String> phrases = textContentAnalyzer.getPhrases(text, phraseSize);
        Map<String, Long> phraseFrequency = textContentAnalyzer.getFrequency(phrases);
        Map<String, Long> topPhrases = textContentAnalyzer.getTopEntries(phraseFrequency, top);

        System.out.println("+---------------------+-----+");
        System.out.printf("| Number of words:    | %3d |\n", wordCount);
        System.out.println("+---------------------+-----+");
        System.out.printf("| Number of sentences:| %3d |\n", sentenceCount);
        System.out.println("+---------------------+-----+");
        System.out.println("+--------------------+-------+");
        System.out.println("| Phrases            | Count |");
        System.out.println("+--------------------+-------+");
        topPhrases.forEach((phrase, count) -> {
            System.out.printf("| %-18s | %5d |\n", phrase, count);
        });
        System.out.println("+--------------------+-------+");
    }
}
