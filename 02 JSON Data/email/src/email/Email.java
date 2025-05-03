package email;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
public class Email {
	public static void main(String[] args) {
        try {
            // Create an ObjectMapper instance
            ObjectMapper mapper = new ObjectMapper();

            // Read the JSON file into a JsonNode object
            JsonNode rootNode = mapper.readTree(new File("data.json"));

            // Extract specific fields from the JSON object
            String name = rootNode.get("name").asText();
            String email = rootNode.get("email").asText();

            // Print the extracted fields
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
