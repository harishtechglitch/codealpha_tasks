import java.util.ArrayList;

public class GradeTracker {
    private ArrayList<Student> students;

    public GradeTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(String name) {
        students.add(new Student(name));
    }

    public Student findStudent(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public void addGrade(String studentName, int grade) {
        Student s = findStudent(studentName);
        if (s != null) {
            s.addGrade(grade);
            System.out.println("Grade added.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void showSummary() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Student Summary Report ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
