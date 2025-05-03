package salary;
import java.io.*;
import java.util.*;
public class Salary {
	public static void main(String[] args) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }

            records.sort((a, b) -> Integer.parseInt(b[3]) - Integer.parseInt(a[3]));

            System.out.println("Top 5 Highest Paid Employees:");
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(String.join(", ", records.get(i)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
