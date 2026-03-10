import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    String group;
    double gpa;

    public Student(String name, String group, double gpa) {
        this.name = name;
        this.group = group;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString() {
        return name + " (" + group + ", GPA=" + gpa + ")";
    }
}

public class StreamPractice {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 2, 8, 3, 10, 2, 8);
        List<String> words = Arrays.asList("apple", "banana", "avocado", "orange", "apple");

        List<Student> students = Arrays.asList(
                new Student("Alice", "SE-2210", 3.8),
                new Student("Bob", "SE-2210", 3.2),
                new Student("Charlie", "SE-2211", 3.9),
                new Student("Diana", "SE-2211", 3.4),
                new Student("Ethan", "SE-2212", 3.6)
        );

        // 1. Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Even numbers: " + evenNumbers);

        // 2. Convert strings to uppercase
        List<String> upperWords = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Uppercase words: " + upperWords);

        // 3. Count strings starting with 'a'
        long countA = words.stream()
                .filter(w -> w.startsWith("a"))
                .count();
        System.out.println("Words starting with 'a': " + countA);

        // 4. Sort numbers in descending order
        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Descending numbers: " + sortedDesc);

        // 5. Find max and min
        int max = numbers.stream().max(Integer::compare).get();
        int min = numbers.stream().min(Integer::compare).get();
        System.out.println("Max: " + max + ", Min: " + min);

        // 6. Remove duplicates
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println("Unique numbers: " + uniqueNumbers);

        // 7. Join strings with comma
        String joined = words.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined words: " + joined);

        // 8. Group students by group
        Map<String, List<Student>> groupStudents =
                students.stream().collect(Collectors.groupingBy(Student::getGroup));
        System.out.println("Students grouped by group: " + groupStudents);

        // 9. Average GPA
        double avgGpa = students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0);
        System.out.println("Average GPA: " + avgGpa);

        // 10. First 3 students with GPA > 3.5
        List<Student> topStudents = students.stream()
                .filter(s -> s.getGpa() > 3.5)
                .limit(3)
                .toList();
        System.out.println("Top students (GPA > 3.5): " + topStudents);

        // 11. Count students with GPA > 3.5
        long countHighGpa = students.stream()
                .filter(s -> s.getGpa() > 3.5)
                .count();
        System.out.println("Students with GPA > 3.5: " + countHighGpa);
    }
}