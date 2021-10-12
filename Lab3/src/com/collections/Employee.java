package com.collections;

import java.util.Objects;

public class Employee {
    private String position;
    private String surname;
    private int birthYear;
    private int salary;

    public Employee(String surname, String position, int birthYear, int salary) {
        this.position = position;
        this.surname = surname;
        this.birthYear = birthYear;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position='" + position + '\'' +
                ", surname='" + surname + '\'' +
                ", birthYear=" + birthYear +
                ", salary=" + salary +
                '}';
    }
}
