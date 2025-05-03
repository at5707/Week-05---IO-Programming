package retention;
import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Service {
    public void serve() {
        System.out.println("Service is running...");
    }
}

class Client {
    @Inject
    private Service service;

    public void start() {
        service.serve();
    }
}
public class Main11 {
	public static void injectDependencies(Object obj) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(obj, field.getType().getDeclaredConstructor().newInstance());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        injectDependencies(client);
        client.start();
    }
}
