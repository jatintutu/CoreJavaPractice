package core.java.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import org.junit.Test;

import core.java.annotations.model.AnnotationsModel1;
import core.java.annotations.model.ClassLevelAnnotations;
import core.java.annotations.model.ClassWithAnnotations;
import core.java.annotations.model.FieldLevelAnnotations;
import core.java.annotations.model.MethodLevelAnnotation;
import core.java.annotations.model.ParameterLevelAnnotation;

/**
 * We have 5 annotations in java.lang package:
 * {@link Deprecated}, {@link Override}, {@link SafeVarargs}, {@link SuppressWarnings}, {@link FunctionalInterface}
 * 
 * We have 4 annotations in java.lang.annotation package:
 * {@link Documented}, {@link Inherited}, {@link Repeatable} {@link Retention}, {@link Target}
 * 
 * @author yalam
 *
 */
public class AnnotationsPractice {

	@SuppressWarnings("deprecation")
	@Test
	public void method1() {
		AnnotationsModel1 annotationsModel1 = new AnnotationsModel1();
		annotationsModel1.method1();
	}

	public void method2(String... args) {
		System.out.println(args);
		Arrays.stream(args).forEach(System.out::println);
	}

	public static void main(String... args) {
		AnnotationsPractice annotationsPractice = new AnnotationsPractice();
		annotationsPractice.method2("jack");
		annotationsPractice.method2("jack", "jill");
		annotationsPractice.method2("jack", "jill", "john");
	}

	@Test
	public void classLevelAnnotations() {
		Class<ClassWithAnnotations> klass = ClassWithAnnotations.class;
		ClassLevelAnnotations[] classLevelAnnotations = klass.getAnnotationsByType(ClassLevelAnnotations.class);
		for (ClassLevelAnnotations annotations : classLevelAnnotations) {
			System.out.println(annotations.annotationType());
			System.out.println(annotations.value1());
		}
	}

	@Test
	public void fieldLevelAnnotations() {
		Class<ClassWithAnnotations> klass = ClassWithAnnotations.class;
		try {
			Field field = klass.getField("fieldWithAnnotation");
			FieldLevelAnnotations[] fieldLevelAnnotations = field.getAnnotationsByType(FieldLevelAnnotations.class);
			for (FieldLevelAnnotations annotation : fieldLevelAnnotations) {
				System.out.println(annotation.age());
				String[] names = annotation.names();
				for (String name : names) {
					System.out.println(name);
				}
			}
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void methodLevelAnnotations() {
		Class<ClassWithAnnotations> klass = ClassWithAnnotations.class;
		try {
			Method method = klass.getMethod("methodWithAnnotation");
			MethodLevelAnnotation[] methodLevelAnnotations = method.getAnnotationsByType(MethodLevelAnnotation.class);
			for (MethodLevelAnnotation methodAnnotation : methodLevelAnnotations) {
				String[] names = methodAnnotation.names();
				for (String name : names) {
					System.out.println(name);
				}
			}

		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void parameterAnnotations() {
		Class<ClassWithAnnotations> klass = ClassWithAnnotations.class;
		try {
			Method method = klass.getMethod("methodWithParameterAnnotation", int.class);
			Parameter[] parameters = method.getParameters();
			System.out.println(parameters[0]);

			Parameter parameter = parameters[0];
			ParameterLevelAnnotation[] parameterLevelAnnotationArray = parameter
					.getAnnotationsByType(ParameterLevelAnnotation.class);
			for (ParameterLevelAnnotation annotation : parameterLevelAnnotationArray) {
				long[] numbers = annotation.numbers();
				for (long num : numbers) {
					System.out.println(num);
				}
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
