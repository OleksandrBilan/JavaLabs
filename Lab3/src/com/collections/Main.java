package com.collections;

import java.util.*;

public class Main {
    private static final TaskManager manager = new TaskManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1: printYoungestAndOldestEmployeeForEachPosition");
            System.out.println("2: printSalariesByCategories");
            System.out.println("3: getEmployeesWithBirthDateBiggerThan");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    manager.printYoungestAndOldestEmployeeForEachPosition();
                    break;
                case "2":
                    manager.printSalariesByCategories();
                    break;
                case "3":
                    manager.getEmployeesWithBirthDateBiggerThan(2002);
                    break;
            }
        }
    }
}
