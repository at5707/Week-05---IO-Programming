package config;
import java.lang.reflect.*;
class Configuration {
    private static String API_KEY = "original_key";

    public static void printKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}
public class Main7 {
	public static void main(String[] args) throws Exception {
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);
        field.set(null, "new_key_123");  // null because it's static
        Configuration.printKey();
    }
}
