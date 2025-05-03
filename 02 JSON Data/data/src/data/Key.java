package data;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
public class Key {
	public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));

            // Call the method to print keys and values
            printKeysAndValues(rootNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to recursively print keys and values from the JsonNode
    public static void printKeysAndValues(JsonNode node) {
        if (node.isObject()) {
            // Iterate through each field in the object
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                System.out.println("Key: " + field.getKey() + " - Value: " + field.getValue());

                // If the value is an object or array, recurse
                if (field.getValue().isObject() || field.getValue().isArray()) {
                    printKeysAndValues(field.getValue());
                }
            }
        } else if (node.isArray()) {
            // If the node is an array, iterate over the elements
            for (JsonNode arrayNode : node) {
                printKeysAndValues(arrayNode);
            }
        }
    }
}
