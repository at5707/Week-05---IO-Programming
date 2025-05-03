package people;
import java.lang.reflect.*;
class Person {
	private int age=25;
}
public class Main {
	public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);
        System.out.println("Old age: " + ageField.get(p));
        ageField.set(p, 35);
        System.out.println("New age: " + ageField.get(p));
    }
}
