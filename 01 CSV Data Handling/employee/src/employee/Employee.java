package employee;
import java.io.FileWriter;
import java.io.IOException;
public class Employee {
	public static void main(String[] args) {
        String[] headers = { "ID", "Name", "Department", "Salary" };
        String[][] data = {
            {"101", "Alice", "IT", "70000"},
            {"102", "Bob", "HR", "60000"},
            {"103", "Charlie", "Finance", "65000"},
            {"104", "David", "IT", "72000"},
            {"105", "Eve", "Marketing", "58000"}
        };

        try (FileWriter writer = new FileWriter("employees.csv")) {
            writer.append(String.join(",", headers)).append("\n");
            for (String[] row : data) {
                writer.append(String.join(",", row)).append("\n");
            }
            System.out.println("CSV file written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
