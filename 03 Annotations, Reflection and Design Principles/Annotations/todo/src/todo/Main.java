package todo;
import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement login", assignedTo = "Bob", priority = "HIGH")
    public void loginFeature() {}

    @Todo(task = "Fix logout bug", assignedTo = "Alice")
    public void logoutFeature() {}

    public void completedFeature() {}
}
public class Main {
	public static void main(String[] args) {
        for (Method m : Project.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println("Method: " + m.getName() +
                    " | Task: " + t.task() +
                    " | Assigned to: " + t.assignedTo() +
                    " | Priority: " + t.priority());
            }
        }
    }
}