package json;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;
public class JSON {
	public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = new File("students.json");
            List<Map<String, Object>> students = mapper.readValue(jsonFile, List.class);

            FileWriter writer = new FileWriter("students.csv");
            // Write headers
            if (!students.isEmpty()) {
                Set<String> headers = students.get(0).keySet();
                writer.write(String.join(",", headers) + "\n");

                // Write values
                for (Map<String, Object> student : students) {
                    List<String> row = new ArrayList<>();
                    for (String header : headers) {
                        row.add(student.get(header).toString());
                    }
                    writer.write(String.join(",", row) + "\n");
                }
            }

            writer.close();
            System.out.println("Converted JSON to CSV.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
