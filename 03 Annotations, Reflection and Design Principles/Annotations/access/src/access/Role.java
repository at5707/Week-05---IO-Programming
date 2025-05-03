package access;
import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminPanel {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted.");
    }

    @RoleAllowed("USER")
    public void viewProfile() {
        System.out.println("Profile viewed.");
    }
}
public class Role {
	static String currentUserRole = "USER";
	public static void main(String[] args) {
		AdminPanel panel = new AdminPanel();

        for (Method method : AdminPanel.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed role = method.getAnnotation(RoleAllowed.class);
                System.out.print("Trying to access " + method.getName() + ": ");
                if (role.value().equals(currentUserRole)) {
                	try {
                        method.invoke(panel);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Access Denied!");
                }
            }
        }
    }
}