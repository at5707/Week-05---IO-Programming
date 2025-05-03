package search;
import java.io.BufferedReader;
import java.io.FileReader;
public class Search {
	public static void main(String[] args) {
        String searchName = "Alice";
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            br.readLine(); // header
            String line;
            while ((line = br.readLine()) != null) {
                String[] emp = line.split(",");
                if (emp[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + emp[2]);
                    System.out.println("Salary: " + emp[3]);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
