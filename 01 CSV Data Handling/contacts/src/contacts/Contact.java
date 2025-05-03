package contacts;
import java.io.*;
import java.util.regex.*;
public class Contact {
	public static void main(String[] args) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
        String phoneRegex = "\\d{10}";

        try (BufferedReader br = new BufferedReader(new FileReader("contacts.csv"))) {
            String header = br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String email = fields[2];
                String phone = fields[3];

                if (!email.matches(emailRegex)) {
                    System.out.println("Invalid Email: " + line);
                }
                if (!phone.matches(phoneRegex)) {
                    System.out.println("Invalid Phone Number: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
