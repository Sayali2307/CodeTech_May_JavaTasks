package codetechtask.level1.task2;

import java.util.ArrayList;
import java.util.Scanner;

class Grade {
    private String subject;
    private double grade;

    public Grade(String subject, double grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

public class studentGradeTracker {
    private ArrayList<Grade> grades;

    public studentGradeTracker() {
        this.grades = new ArrayList<>();
    }

    public void addGrade(String subject, double grade) {
        grades.add(new Grade(subject, grade));
    }

    public void editGrade(String subject, double newGrade) {
        for (Grade g : grades) {
            if (g.getSubject().equalsIgnoreCase(subject)) {
                g.setGrade(newGrade);
                return;
            }
        }
        System.out.println("Subject not found.");
    }

    public void deleteGrade(String subject) {
        grades.removeIf(g -> g.getSubject().equalsIgnoreCase(subject));
    }

    public void displayGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }

        double total = 0;
        System.out.println("Subject\t\tGrade");
        for (Grade g : grades) {
            System.out.println(g.getSubject() + "\t\t" + g.getGrade());
            total += g.getGrade();
        }
        double average = total / grades.size();
        System.out.println("\nAverage Grade: " + average);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        studentGradeTracker tracker = new studentGradeTracker();

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Grade");
            System.out.println("2. Edit Grade");
            System.out.println("3. Delete Grade");
            System.out.println("4. Display Grades");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter subject: ");
                    scanner.nextLine(); // consume newline character
                    String subject = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    tracker.addGrade(subject, grade);
                    break;
                case 2:
                    System.out.print("Enter subject to edit: ");
                    scanner.nextLine(); // consume newline character
                    String editSubject = scanner.nextLine();
                    System.out.print("Enter new grade: ");
                    double newGrade = scanner.nextDouble();
                    tracker.editGrade(editSubject, newGrade);
                    break;
                case 3:
                    System.out.print("Enter subject to delete: ");
                    scanner.nextLine(); // consume newline character
                    String deleteSubject = scanner.nextLine();
                    tracker.deleteGrade(deleteSubject);
                    break;
                case 4:
                    tracker.displayGrades();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
