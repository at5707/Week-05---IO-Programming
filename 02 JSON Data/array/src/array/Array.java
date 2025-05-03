package array;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
class Car {
    private String brand;
    private int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
public class Array {
	public static void main(String[] args) {
        // Create a list of car objects
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", 2021));
        cars.add(new Car("Honda", 2020));
        cars.add(new Car("Ford", 2019));

        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert the list of cars to a JSON array
            String jsonArray = mapper.writeValueAsString(cars);

            // Print the resulting JSON array
            System.out.println("JSON Array: " + jsonArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
