package student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class Student {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "John Doe");
        student.put("age", 20);
        
        ArrayNode subjects = student.putArray("subjects");
        subjects.add("Math").add("Physics").add("Chemistry");
        
     // Printing the JSON object with pretty print
        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(prettyJson);

        // Optional: write to a JSON file
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("student.json"), student);
    }
}
