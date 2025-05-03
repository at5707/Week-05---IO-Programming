package update;
import java.io.*;
import java.util.*;
public class Update {
	public static void main(String[] args) {
        List<String[]> updated = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String line = br.readLine(); // header
            updated.add(line.split(","));
            while ((line = br.readLine()) != null) {
                String[] emp = line.split(",");
                if (emp[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(emp[3]) * 1.1;
                    emp[3] = String.valueOf((int) salary);
                }
                updated.add(emp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("updated_employees.csv")) {
            for (String[] row : updated) {
                writer.write(String.join(",", row) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
