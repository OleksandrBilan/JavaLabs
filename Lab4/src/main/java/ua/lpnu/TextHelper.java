package ua.lpnu;

import java.io.*;
import java.util.Scanner;

public class TextHelper {

    private Scanner scanner;
    private final File file;
    private final StringBuilder stringBuilder;

    public TextHelper(File file) {
        this.file = file;
        this.stringBuilder = new StringBuilder();
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Wrong file");
            System.exit(0);
        }
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }

    public void dispose() {
        scanner.close();
    }

    private int getMinIndex(int startFrom) {
        int pointOccurrence = stringBuilder.indexOf(".", startFrom) == -1 ? Integer.MAX_VALUE : stringBuilder.indexOf(".", startFrom);
        int questionOccurrence = stringBuilder.indexOf("?", startFrom) == -1 ? Integer.MAX_VALUE : stringBuilder.indexOf("?", startFrom);
        int exclamationOccurrence = stringBuilder.indexOf("!", startFrom) == -1 ? Integer.MAX_VALUE : stringBuilder.indexOf("!", startFrom);

        return Math.min(Math.min(pointOccurrence, questionOccurrence), exclamationOccurrence);
    }

    public String getLastStatement() {
        var textHelper = new TextHelper(file);
        var lastSentence = "";
        while (textHelper.hasNext()) {
            lastSentence = textHelper.getNextStatement();
        }

        textHelper.dispose();
        return lastSentence;
    }

    public String getNextStatement() {
        String line;
        int minIndex = -1;
        while (scanner.hasNext() && (minIndex = getEndOfStatement(stringBuilder.toString())) == -1) {
            line = scanner.nextLine();
            stringBuilder.append(line.concat("\n"));
            if ((minIndex = getEndOfStatement(stringBuilder.toString())) != -1) {
                break;
            }
        }

        line = stringBuilder.substring(0, minIndex + 1);
        stringBuilder.delete(0, minIndex + 1);

        return line;
    }

    private int getEndOfStatement(String line) {
        if (line.contains(".") || line.contains("?") || line.contains("!")) {
            int index = 0;
            while ((index = getMinIndex(index + 1)) != Integer.MAX_VALUE) {
                int prev = line.substring(0, index + 1).lastIndexOf(" ");
                int next = line.indexOf(" ", index + 1);

                if (next == -1) {
                    return index;
                }

                if (!EmailValidator.isEmailValid(line.substring(prev, next))) {
                    break;
                }
            }

            return index == Integer.MAX_VALUE ? -1 : index;
        }

        return -1;
    }
}
