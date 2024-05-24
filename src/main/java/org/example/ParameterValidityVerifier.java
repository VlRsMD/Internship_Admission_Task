package org.example;

public class ParameterValidityVerifier {
    public void verifyTopParameterValidity(Integer top) {
        try {
            if (top <= 0) {
                System.err.println("Invalid value for -top. It should be a positive integer.");
                return;
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format for -top.");
            return;
        }
    }

    public void verifyFilePathValidityParameter(String filePath) {
        if (filePath.isEmpty()) {
            System.err.println("File path not provided. Please use the -file parameter to specify the path to the text file.");
            return;
        }
    }

    public void verifyPhraseSizeParameterValidity(Integer phraseSize) {
        try {
            if (phraseSize <= 0) {
                System.err.println("Invalid value for -phraseSize. It should be a positive integer.");
                return;
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format for -phraseSize.");
            return;
        }
    }

}
