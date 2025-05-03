package age;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
public class Age {
	public static void main(String[] args) {
        try {
            // Create an ObjectMapper instance
            ObjectMapper mapper = new ObjectMapper();

            // Read JSON data from a file
            JsonNode rootNode = mapper.readTree(new File("users.json"));

            // Assuming the root node is an array of users
            if (rootNode.isArray()) {
                for (JsonNode userNode : rootNode) {
                    // Extract name and age fields from each user
                    String name = userNode.get("name").asText();
                    int age = userNode.get("age").asInt();

                    // Filter users older than 25 years
                    if (age > 25) {
                        System.out.println("User: " + name + ", Age: " + age);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
