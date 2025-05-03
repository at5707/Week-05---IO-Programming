package csvdata;
import java.io.*;
import java.util.*;
class Student {
    int id;
    String name;
    int age;
    int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String toString() {
        return id + " - " + name + " - Age: " + age + " - Marks: " + marks;
    }
}
public class CSVd {
	public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3])
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        students.forEach(System.out::println);
    }
}
