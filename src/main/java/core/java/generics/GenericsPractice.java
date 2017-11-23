package core.java.generics;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import core.java.generics.model.GenericModel1;
import core.java.generics.model.GenericSubClass;
import core.java.generics.model.GenericSuperClass;
import core.java.generics.model.Student;

public class GenericsPractice {

	@Test
	public void method1() {
		// until jdk 6
		GenericModel1<String> genericModel1 = new GenericModel1<String>();
		genericModel1.method2("Jack");
		genericModel1.method1("John");

		// from jdk 7
		GenericModel1<String> genericModel2 = new GenericModel1<>();
		genericModel2.method1("Tom");
		genericModel2.method2("Tan");

		GenericModel1<Integer> genericModel3 = new GenericModel1<>();
		genericModel3.method1(25);
		genericModel3.method2(35);

		GenericModel1<Student> genericModel4 = new GenericModel1<>();
		genericModel4.method1(new Student());
	}

	@Test
	public void method3() {
		GenericModel1<String> genericModel1 = new GenericModel1<>();
		genericModel1.method3("tom", "Jack");
		genericModel1.method3(25, "tumb");
	}

	@Test
	public void method4() {
		//untill jdk 7
		String result1 = GenericModel1.<String>method4("Jill");
		int number = GenericModel1.<Integer>method4(25);
		System.out.println(result1);
		System.out.println(number);

		// from jdk 8
		String result2 = GenericModel1.method4("Tom");
		int number2 = GenericModel1.method4(45);
		System.out.println(result2 + number2);
	}

	@Test
	public void method5() {
		GenericModel1<String> genericModel1 = new GenericModel1<>();

		GenericSuperClass genericSuperClass = new GenericSuperClass();
		genericModel1.method5(genericSuperClass);

		GenericSubClass genericSubClass = new GenericSubClass();
		genericModel1.method5(genericSubClass);

		//		bbelewlow line will give an erro
		//		genericModel1.method5("Sam");
	}

	@Test
	public void method6() {
		GenericModel1<String> genericModel1 = new GenericModel1<>();

		List<String> names = Arrays.asList("jack", "jill", "john", "sam", "kom", "mill", "scott", "matt");
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
		genericModel1.method6(names);
		genericModel1.method6(numbers);
	}
}
