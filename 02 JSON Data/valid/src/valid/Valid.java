package valid;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;

import static com.networknt.schema.JsonSchemaFactory.getInstance;

import java.io.File;
import java.util.Set;

public class Valid {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Load schema
        JsonSchemaFactory factory = getInstance();
        JsonSchema schema = factory.getSchema(new File("schema.json"));

        // Load data to validate
        JsonNode json = mapper.readTree(new File("car.json"));

        // Validate
        Set<ValidationMessage> errors = schema.validate(json);
        if (errors.isEmpty()) {
            System.out.println("✅ JSON is valid!");
        } else {
            System.out.println("❌ JSON is invalid. Errors:");
            errors.forEach(System.out::println);
        }
    }
}
