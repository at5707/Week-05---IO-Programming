package deprecated;
class LegacyAPI {
	@Deprecated
	void oldFeature() {
		System.out.println("Old Feature-Deprecated");
	}
	void newFeature() {
		System.out.println("New Feature");
	}
}
public class Main2 {
	public static void main(String[] args) {
		LegacyAPI api=new LegacyAPI();
		api.oldFeature();
		api.newFeature();
	}
}