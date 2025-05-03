package duplicate;
import java.io.*;
import java.util.*;
public class Duplicate {
	public static void main(String[] args) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                if (!seen.add(id)) {
                    duplicates.add(line);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate records:");
                duplicates.forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
