package Lab2;

import java.util.Arrays;
import java.util.Scanner;
public class Student {
    private int id;
    private String name;
    private String dateOfBirth;
    private String address;
    private double gpa;

    public Student(int id, String name, String dateOfBirth, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Date of Birth: " + dateOfBirth + ", Address: " + address + ", GPA: " + gpa;
    }
}
