package core.java.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Arrays;

import org.junit.Test;

import core.java.annotations.model.AnnotationsModel1;

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
	}
}
