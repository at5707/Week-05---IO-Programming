package annotation;
import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Timer {
    @LogExecutionTime
    public void task1() {
        for (int i = 0; i < 1_000_000; i++);
    }

    @LogExecutionTime
    public void task2() {
        for (int i = 0; i < 10_000_000; i++);
    }
}
public class Main9 {
	public static void main(String[] args) throws Exception {
        Timer t = new Timer();
        for (Method m : Timer.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(t);
                long end = System.nanoTime();
                System.out.println(m.getName() + " executed in " + (end - start) + " ns");
            }
        }
    }
}
