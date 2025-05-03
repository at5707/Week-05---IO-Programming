package dynamic;
import java.lang.reflect.*;
class Student {
    String name;
    public Student() {
        this.name = "Default";
    }
}
public class Main4 {
	public static void main(String[] args) throws Exception {
        Class<?> clazz = Student.class;
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object obj = constructor.newInstance();
        System.out.println("Created object of class: " + obj.getClass().getSimpleName());
    }
}
