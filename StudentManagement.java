package Lab2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentManagement {
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add student");
            System.out.println("2. Edit student by id");
            System.out.println("3. Delete student by id");
            System.out.println("4. Sort students by gpa");
            System.out.println("5. Sort students by name");
            System.out.println("6. Show students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    sortStudentsByGPA();
                    break;
                case 5:
                    sortStudentsByName();
                    break;
                case 6:
                    showStudents();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student date of birth: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter student address: ");
        String address = scanner.nextLine();
        System.out.print("Enter student GPA: ");
        double gpa = scanner.nextDouble();

        Student student = new Student(id, name, dateOfBirth, address, gpa);
        students[studentCount++] = student;

        System.out.println("Student added successfully!");
    }

    public static void editStudent() {
        System.out.print("Enter student ID to edit: ");
        int idToEdit = scanner.nextInt();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == idToEdit) {
                System.out.print("Enter new GPA for student " + students[i].getName() + ": ");
                double newGPA = scanner.nextDouble();
                students[i].setGpa(newGPA);
                System.out.print("Enter new birthday for student " + students[i].getName() + ": ");
                String newDateOfBirth = scanner.next();
                students[i].setDateOfBirth(newDateOfBirth);
                System.out.print("Enter new Address for student " + students[i].getName() + ": ");
                String newAddress = scanner.next();
                students[i].setAddress(newAddress);
                System.out.println("Student edited successfully!");
                return;
            }
        }
        System.out.println("Student not found with ID: " + idToEdit);
    }

    public static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int idToDelete = scanner.nextInt();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == idToDelete) {
                // Shift elements to the left to remove the student
                System.arraycopy(students, i + 1, students, i, studentCount - i - 1);
                studentCount--;
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found with ID: " + idToDelete);
    }

    public static void sortStudentsByGPA() {
        Arrays.sort(students, 0, studentCount, (s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        System.out.println("Students sorted by GPA.");
    }

    public static void sortStudentsByName() {
        Arrays.sort(students, 0, studentCount, (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
        System.out.println("Students sorted by name.");
    }

    public static void showStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println(students[i]);
            }
        }
    }

}
