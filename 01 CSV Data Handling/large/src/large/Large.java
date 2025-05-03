package large;
import java.io.*;
public class Large {
	public static void main(String[] args) {
        int batchSize = 100;
        int totalCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("large.csv"))) {
            String line;
            br.readLine(); // skip header

            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
                totalCount++;
                if (count == batchSize) {
                    System.out.println("Processed " + totalCount + " records");
                    count = 0;
                }
            }

            if (count > 0) {
                System.out.println("Processed final " + count + " records. Total = " + totalCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
