package com.collections;

import java.io.*;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    private static List<Employee> firstFileData;
    private static List<Employee> secondFileData;

    private static final File firstFile = new File(".\\resources\\data.txt");
    private static final File secondFile = new File(".\\resources\\data2.txt");

    public void printYoungestAndOldestEmployeeForEachPosition() {
        firstFileData = readData(firstFile);

        var positions = firstFileData.stream().map(Employee::getPosition).collect(Collectors.toSet());
        var map = new HashMap<String, List<Employee>>();
        for (var position: positions) {
            map.put(position, firstFileData.stream().filter(employee ->
                    employee.getPosition().equals(position)).toList());
        }

        System.out.println("Created HashMap: ");
        for (var entry: map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        for (var entry: map.entrySet()) {
            System.out.println("\nMax age for " + entry.getKey() + " - " + Collections.max(entry.getValue().stream()
                    .map(employee -> Year.now().getValue() - employee.getBirthYear()).toList()));
            System.out.println("Min age for " + entry.getKey() + " - " + Collections.min(entry.getValue().stream()
                    .map(employee -> Year.now().getValue() - employee.getBirthYear()).toList()));
        }
    }

    public void printSalariesByCategories() {
        firstFileData = readData(firstFile);

        var salaryList = firstFileData.stream().map(Employee::getSalary).collect(Collectors.toList());
        System.out.println("Min salary: " + Collections.min(salaryList));
        System.out.println("Max salary: " + Collections.max(salaryList));

        var map = new HashMap<SalarySize, List<Employee>>();
        for (var salarySize: SalarySize.values()) {
            map.put(salarySize, firstFileData.stream().filter(employee -> employee.getSalary() >= salarySize.getMin()
                    && employee.getSalary() <= salarySize.getMax()).collect(Collectors.toList()));
        }

        System.out.println(map);
    }

    public void getEmployeesWithBirthDateBiggerThan(int year) {
        firstFileData = readData(firstFile);
        secondFileData = readData(secondFile);

        var employees = new HashSet<>(firstFileData);
        employees.addAll(new HashSet<>(secondFileData));

        System.out.println("Employees with birth date bigger than " + year + ": ");
        System.out.println(employees.stream().filter(x -> x.getBirthYear() >= year).toList());
    }

    private static List<Employee> readData(File file) {
        int lineNumber = 0;
        var list = new LinkedList<Employee>();
        try {
            var br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                ++lineNumber;
                var data = line.split(",");
                list.add(new Employee(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(1);
        } catch (NumberFormatException ex) {
            System.out.printf("Sorry, but you have invalid data in %d line. Fix it and try again", lineNumber);
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Sorry, but you get unexpected error while reading file");
            System.exit(1);
        }

        return list;
    }
}
