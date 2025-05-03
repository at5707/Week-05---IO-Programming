package filter;
import java.io.BufferedReader;
import java.io.FileReader;
public class Filter {
	public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] student = line.split(",");
                int marks = Integer.parseInt(student[3]);
                if (marks > 80) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
