package core.java.annotations.model;

@ClassLevelAnnotations(value1 = 5)
public class ClassWithAnnotations {

	@FieldLevelAnnotations(age = 30, names = { "Jack", "Jill" })
	public String fieldWithAnnotation;

	@MethodLevelAnnotation(names = { "Tom", "Jerry", "John" })
	public void methodWithAnnotation() {
	}

	public void methodWithParameterAnnotation(@ParameterLevelAnnotation(numbers = { 10, 20, 30 }) int num) {

	}
}
