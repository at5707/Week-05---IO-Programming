import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class Merge {
    public static void main(String[] args) {
        try {
            // Create an ObjectMapper instance to read and write JSON
            ObjectMapper mapper = new ObjectMapper();

            // Read two JSON objects from files (you can also use strings or other sources)
            JsonNode json1 = mapper.readTree(new File("json1.json"));
            JsonNode json2 = mapper.readTree(new File("json2.json"));

            // Ensure both are ObjectNodes (JSON objects)
            if (json1.isObject() && json2.isObject()) {
                // Merge json2 into json1 by adding fields from json2 into json1
                ObjectNode mergedJson = (ObjectNode) json1;

                // Iterate through all fields of json2 and add them to mergedJson
                json2.fieldNames().forEachRemaining(fieldName -> {
                    JsonNode value = json2.get(fieldName);
                    mergedJson.set(fieldName, value);  // Correct method to add field to ObjectNode
                });

                // Print the merged JSON to the console
                System.out.println("Merged JSON:");
                System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));

                // Optionally, write the merged JSON to a new file
                mapper.writeValue(new File("merged.json"), mergedJson);
            } else {
                System.out.println("Both JSON files must be objects.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
