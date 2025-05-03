package json;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class UserJson {
    @JsonField(name = "user_name")
    String username;

    @JsonField(name = "email_id")
    String email;

    public UserJson(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws Exception {
        Map<String, String> jsonMap = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField jf = field.getAnnotation(JsonField.class);
                jsonMap.put(jf.name(), String.valueOf(field.get(obj)));
            }
        }

        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }
        if (!jsonMap.isEmpty()) json.setLength(json.length() - 2); // Remove last comma
        json.append("}");
        return json.toString();
    }
}
public class Main11 {
	public static void main(String[] args) throws Exception {
        UserJson user = new UserJson("john_doe", "john@example.com");
        System.out.println(JsonSerializer.toJson(user));
    }
}
