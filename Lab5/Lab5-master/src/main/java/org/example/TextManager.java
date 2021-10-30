package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class TextManager {

    private final int n;

    public TextManager(int n) {
        this.n = n;
    }

    public String deleteAllWordsWithLengthN(String line) {
        String lengthRegex  = "\\b[^aeiouyAEIOUY]\\w{%d}\\b";

        var lengthPattern = Pattern.compile(String.format(lengthRegex, n - 1));
        var lengthMatcher = lengthPattern.matcher(line);

        return lengthMatcher.replaceAll("");
    }

    public List<String> selectThreeWords(String line) {
        var wordRegex = "[A-Z]\\w{0,}\\W{1,}";
        var threePattern = Pattern.compile(wordRegex.repeat(3));

        var remainingWord = new LinkedList<>();
        var result = new LinkedList<String>();
        var words = line.split("[\\s;,!?.]");
        remainingWord.addAll(Arrays.asList(words).subList(Math.max(words.length - 2, 0), words.length));

        if (remainingWord.size() > 3) {
            var wordString = remainingWord.toString();
            remainingWord.clear();
            result.addAll(selectThreeWords(wordString));
        }

        var threeMatcher = threePattern.matcher(line);
        while (threeMatcher.find()) {
            result.add(line.substring(threeMatcher.start(), threeMatcher.end() - 1));
        }

        return result;
    }
}
