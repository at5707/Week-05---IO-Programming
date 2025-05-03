package json;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;
public class CSV {
	public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.csv"));
            String headerLine = br.readLine();
            String[] headers = headerLine.split(",");

            List<Map<String, String>> students = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> student = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], values[i]);
                }
                students.add(student);
            }
            br.close();

            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("students_from_csv.json"), students);
            System.out.println("Converted CSV to JSON.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
