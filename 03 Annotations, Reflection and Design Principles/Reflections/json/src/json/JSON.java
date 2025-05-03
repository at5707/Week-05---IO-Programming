package json;
import java.lang.reflect.*;
class Product {
    public String name = "Laptop";
    public double price = 999.99;
}
public class JSON {
	public static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            json.append("\"").append(field.getName()).append("\": ");
            json.append("\"").append(field.get(obj)).append("\", ");
        }
        if (json.length() > 1) json.setLength(json.length() - 2); // remove last comma
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        Product p = new Product();
        System.out.println(toJson(p));
    }
}
