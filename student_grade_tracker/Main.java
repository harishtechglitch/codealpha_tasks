import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GradeTracker tracker = new GradeTracker();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. View Summary Report");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    tracker.addStudent(name);
                }
                case 2 -> {
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter grade: ");
                    int grade = sc.nextInt();
                    tracker.addGrade(name, grade);
                }
                case 3 -> tracker.showSummary();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option!");
            }

        } while (choice != 0);

        sc.close();
    }
}
