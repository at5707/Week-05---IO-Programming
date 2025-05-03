package emails;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emails {
	public static void main(String[] args) throws Exception {
        // Create ObjectMapper for JSON processing
        ObjectMapper mapper = new ObjectMapper();

        // Load the JSON data (user.json) to validate
        JsonNode json = mapper.readTree(new File("user.json"));

        // Get the email field from the JSON
        String email = json.get("email").asText();

        // Validate the email format
        if (isValidEmail(email)) {
            System.out.println("✅ The email is valid!");
        } else {
            System.out.println("❌ Invalid email format.");
        }
    }

    // Function to validate email using a regex pattern
    public static boolean isValidEmail(String email) {
        // Simple regex pattern for validating email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}