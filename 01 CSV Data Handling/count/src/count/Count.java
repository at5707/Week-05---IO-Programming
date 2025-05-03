package count;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Count {
	public static void main(String[] args) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            br.readLine(); // skip header
            while (br.readLine() != null) {
                count++;
            }
            System.out.println("Total records: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
