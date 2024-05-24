package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileContentReader {
    public StringBuilder readFileContent (String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(" ");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            System.exit(0);
        }
        return content;
    }

    public String extractText(String filePath) {
        String text = readFileContent(filePath).toString().trim();
        if (text.isEmpty()) {
            System.err.println("The file is empty.");
            System.exit(0);
        }
        return text;
    }
}
