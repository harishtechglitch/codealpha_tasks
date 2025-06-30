import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) sum += grade;
        return (double) sum / grades.size();
    }

    public int getHighest() {
        if (grades.isEmpty()) return 0;
        int max = grades.get(0);
        for (int g : grades) if (g > max) max = g;
        return max;
    }

    public int getLowest() {
        if (grades.isEmpty()) return 0;
        int min = grades.get(0);
        for (int g : grades) if (g < min) min = g;
        return min;
    }

    @Override
    public String toString() {
        return name + " - Grades: " + grades + " | Avg: " + String.format("%.2f", getAverage())
                + " | Highest: " + getHighest() + " | Lowest: " + getLowest();
    }
}
