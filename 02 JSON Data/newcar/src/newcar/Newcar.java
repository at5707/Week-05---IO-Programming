package newcar;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
class Car {
    private String brand;
    private int year;

    // Constructors, getters, and setters
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
public class Newcar {
	public static void main(String[] args) {
        // Create a list of Car objects
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", 2023));
        cars.add(new Car("BMW", 2022));
        cars.add(new Car("Audi", 2021));

        // Convert the list of Java objects into a JSON array
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Convert the list into a JSON array string
            String jsonArray = objectMapper.writeValueAsString(cars);

            // Print the JSON array
            System.out.println("JSON Array: ");
            System.out.println(jsonArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
