package bugs;
import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
	String description();
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
	BugReport[] value();
}
class QA {
	@BugReport(description="Null pointer issue")
	@BugReport(description="UI not responsive")
	public void checkBugs() {}
}
public class Main5 {
	public static void main(String[] args) throws Exception {
		Method method=QA.class.getMethod("checkBugs");
		BugReport[] reports=method.getAnnotationsByType(BugReport.class);
		for (BugReport report:reports) {
			System.out.println("Bug: "+report.description());
		}
	}
}
