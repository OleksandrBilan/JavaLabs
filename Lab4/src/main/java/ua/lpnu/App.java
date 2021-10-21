package ua.lpnu;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        var wrongEmails = new LinkedList<>();
        var correctEmails = new LinkedList<>();

        var inputFile = new File("src/main/resources/input.txt");
        var textHelper = new TextHelper(inputFile);
        var lastSentence = textHelper.getLastStatement();

        var resultFile = new File("src/main/resources/result.txt");
        try (var writer = new BufferedWriter(new FileWriter(resultFile))) {
            while (textHelper.hasNext()) {
                var sentence = textHelper.getNextStatement();
                var words = sentence.split(" ");
                var emailsInSentence = Arrays.stream(words)
                                                        .filter(EmailValidator::isEmailValid)
                                                        .collect(Collectors.toList());
                if (!emailsInSentence.isEmpty()) {
                    correctEmails.addAll(emailsInSentence);
                    sentence = lastSentence;
                }

                wrongEmails.addAll(Arrays.stream(words)
                           .filter(word -> word.contains("@") && !EmailValidator.isEmailValid(word))
                           .collect(Collectors.toList()));

                writer.append(sentence);
            }
            textHelper.dispose();
        } catch (IOException ex) {
            System.out.println("Unexpected problem has occurred");
            return;
        }

        System.out.println("Correct emails:");
        correctEmails.forEach(System.out::println);

        System.out.println("\nWrong emails:");
        wrongEmails.forEach(System.out::println);
    }
}
