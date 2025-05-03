package invoke;
import java.lang.reflect.*;
class Calculator {
	private int multiply(int a,int b) {
		return a*b;
	}
}
public class Main3 {
	public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(calc, 6, 7);
        System.out.println("Result: " + result);
    }
}
