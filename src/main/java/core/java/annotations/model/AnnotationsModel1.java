package core.java.annotations.model;

public class AnnotationsModel1 {

	@Deprecated
	@Name(name = "jill")
	@Name
	public void method1() {
		System.out.println("AnnotationsModel1.method1");
	}
}