package invert;
import java.lang.reflect.*;
class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}
public class Main5 {
	public static void main(String[] args) throws Exception {
        MathOperations math = new MathOperations();
        String methodName = "multiply"; // dynamically choose method

        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
        Object result = method.invoke(math, 5, 4);
        System.out.println("Result of " + methodName + ": " + result);
    }
}