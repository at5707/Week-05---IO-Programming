package car;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

class Car {
    public String brand;
    public int year;

    // Constructor
    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
}

public class Car2 {
    public static void main(String[] args) throws Exception {
        // Create a Car object
        Car car = new Car("Toyota", 2022);

        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();
        
        // Convert Car object to JSON
        String carJson = mapper.writeValueAsString(car);
        
        // Print the JSON representation of the Car object
        System.out.println(carJson);

        // Optionally, write the JSON to a file
        mapper.writeValue(new File("car.json"), car);
    }
}
