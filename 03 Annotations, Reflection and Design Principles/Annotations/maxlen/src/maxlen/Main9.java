package maxlen;
import java.lang.annotation.*;
import java.lang.reflect.Field;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    String username;

    public User(String username) throws Exception {
        this.username = username;
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength max = field.getAnnotation(MaxLength.class);
                field.setAccessible(true);
                String val = (String) field.get(this);
                if (val.length() > max.value()) {
                    throw new IllegalArgumentException(field.getName() + " exceeds max length " + max.value());
                }
            }
        }
    }
}
public class Main9 {
	public static void main(String[] args) {
        try {
            User u = new User("JohnDoe12345"); // Will throw exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
