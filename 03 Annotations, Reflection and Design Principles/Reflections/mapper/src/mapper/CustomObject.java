package mapper;
import java.lang.reflect.*;
import java.util.*;
class User {
    public String name;
    public int age;
}
public class CustomObject {
	public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            if (properties.containsKey(field.getName())) {
                field.setAccessible(true);
                field.set(instance, properties.get(field.getName()));
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Alice");
        data.put("age", 30);

        User user = toObject(User.class, data);
        System.out.println("Name: " + user.name + ", Age: " + user.age);
    }
}
