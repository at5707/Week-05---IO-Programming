package merge;
import java.io.*;
import java.util.*;
public class Merge {
	 public static void main(String[] args) {
	        Map<String, String[]> map1 = new HashMap<>();
	        try (BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"))) {
	            br1.readLine(); // skip header
	            String line;
	            while ((line = br1.readLine()) != null) {
	                String[] parts = line.split(",");
	                map1.put(parts[0], parts);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        try (BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
	             FileWriter writer = new FileWriter("merged.csv")) {

	            writer.write("ID,Name,Age,Marks,Grade\n");
	            br2.readLine(); // skip header
	            String line;
	            while ((line = br2.readLine()) != null) {
	                String[] parts = line.split(",");
	                String id = parts[0];
	                String[] data1 = map1.get(id);
	                if (data1 != null) {
	                    writer.write(String.join(",", data1[0], data1[1], data1[2], parts[1], parts[2]) + "\n");
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
