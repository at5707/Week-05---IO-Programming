package importantmethod;
import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
	String level() default "HIGH";
}
class MyService {
	@ImportantMethod
	public void saveData() {
		System.out.println("Saving data....");
	}
	@ImportantMethod(level = "MEDIUM")
    public void loadData() {
        System.out.println("Loading data...");
    }
	public void cleanUp() {
        System.out.println("Cleaning...");
    }
}
public class Main6 {
	public static void main(String[] args) {
		for (Method m:MyService.class.getDeclaredMethods()) {
			if (m.isAnnotationPresent(ImportantMethod.class)) {
				ImportantMethod im=m.getAnnotation(ImportantMethod.class);
				System.out.println(m.getName()+" - Importance: "+im.level());
			}
		}
	}
}