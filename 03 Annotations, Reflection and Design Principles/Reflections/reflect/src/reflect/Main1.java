package reflect;
import java.lang.reflect.*;
public class Main1 {
	public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.util.ArrayList"); // Replace with any class
        System.out.println("Class: " + clazz.getName());

        System.out.println("Fields:");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println("  " + f);
        }

        System.out.println("Methods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println("  " + m);
        }

        System.out.println("Constructors:");
        for (Constructor<?> c : clazz.getDeclaredConstructors()) {
            System.out.println("  " + c);
        }
    }
}
