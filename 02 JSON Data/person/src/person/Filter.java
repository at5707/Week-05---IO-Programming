package person;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
class Person {
	private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class Filter {
    public static void main(String[] args) {
        // Sample JSON string
        String json = "["
                + "{\"name\": \"John\", \"age\": 28},"
                + "{\"name\": \"Anna\", \"age\": 22},"
                + "{\"name\": \"Mike\", \"age\": 30},"
                + "{\"name\": \"Sara\", \"age\": 24}"
                + "]";

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Parse the JSON string into an array of JsonNode objects
            JsonNode rootNode = mapper.readTree(json);
            
            // Create a list to store the filtered persons
            List<Person> persons = new ArrayList<>();
            
            // Convert JsonNode to Person objects and filter by age > 25
            rootNode.forEach(node -> {
                String name = node.get("name").asText();
                int age = node.get("age").asInt();
                persons.add(new Person(name, age));
            });

            // Filter persons where age > 25 using streams
            List<Person> filteredPersons = persons.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());

            // Print the filtered list
            System.out.println("Filtered Records (Age > 25):");
            filteredPersons.forEach(person -> 
                    System.out.println(person.getName() + " - Age: " + person.getAge()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
