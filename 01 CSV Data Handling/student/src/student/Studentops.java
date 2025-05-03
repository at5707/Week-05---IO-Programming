package student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Studentops {
	public static void main(String[] args) {
        String csvFile = "students.csv";  // Path to your CSV file
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read and skip header
            String header = br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] student = line.split(csvSplitBy);

                System.out.println("Student Record:");
                System.out.println("ID    : " + student[0]);
                System.out.println("Name  : " + student[1]);
                System.out.println("Age   : " + student[2]);
                System.out.println("Marks : " + student[3]);
                System.out.println("----------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
