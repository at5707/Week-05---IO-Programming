package suppress;
import java.util.ArrayList;
import java.util.List;
public class Main3 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List rawList=new ArrayList();
		rawList.add("Test");
		System.out.println(rawList.get(0));
	}
}