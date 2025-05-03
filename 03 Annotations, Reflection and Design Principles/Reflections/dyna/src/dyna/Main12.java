package dyna;
import java.lang.reflect.*;
class Processor {
    public void heavyTask() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("Heavy task done.");
    }

    public void lightTask() {
        System.out.println("Light task done.");
    }
}
public class Main12 {
	public static void main(String[] args) throws Exception {
        Processor p = new Processor();
        for (Method method : Processor.class.getDeclaredMethods()) {
            long start = System.nanoTime();
            method.invoke(p);
            long duration = System.nanoTime() - start;
            System.out.println("Executed " + method.getName() + " in " + duration + " ns");
        }
    }
}
