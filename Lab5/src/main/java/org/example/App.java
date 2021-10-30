package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the word length:");
        var consoleScanner = new Scanner(System.in);
        int n = consoleScanner.nextInt();
        var textManager = new TextManager(n);
        List<String> threeWords = new LinkedList<>();

        var inputFile = new File("src/main/resources/input.txt");
        var outputFile = new File("src/main/resources/output.txt");

        var writer = new BufferedWriter(new FileWriter(outputFile));
        try (var fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNext()) {
                var line = fileScanner.nextLine().concat("\n");

                threeWords.addAll(textManager.selectThreeWords(line));
                line = textManager.deleteAllWordsWithLengthN(line);

                writer.append(line);
            }
        } catch (IOException ex) {
            System.out.println("Wrong input file!");
        }
        writer.close();

        System.out.println("Capital words by 3 in row: ");
        threeWords.forEach(System.out::println);
    }
}
