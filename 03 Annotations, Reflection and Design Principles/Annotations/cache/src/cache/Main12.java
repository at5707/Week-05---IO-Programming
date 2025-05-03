package cache;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class Calculator {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int expensiveOperation(int x) {
        if (cache.containsKey(x)) {
            System.out.println("Returning cached result for: " + x);
            return cache.get(x);
        }
        System.out.println("Computing result for: " + x);
        int result = x * x; // Simulate heavy calculation
        cache.put(x, result);
        return result;
    }
}
public class Main12 {
	public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        System.out.println(calc.expensiveOperation(5));
        System.out.println(calc.expensiveOperation(5)); // Should use cache
        System.out.println(calc.expensiveOperation(7));
    }
}
