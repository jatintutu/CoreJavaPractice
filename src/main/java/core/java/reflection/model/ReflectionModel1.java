package core.java.reflection.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ReflectionModel1 extends Object implements Serializable {

	private static final long serialVersionUID = -2693156947838409146L;

	public ReflectionModel1() {

	}

	public ReflectionModel1(int number) {

	}

	public ReflectionModel1(String str) {
		System.out.println("ReflectionModel1.constructor.str: " + str);
	}

	public void method1() {
		System.out.println("ReflectionModel1.method1()");
	}

	public void method2(String name) {
		System.out.println("Hello: " + name);
	}

	public void method3(String[] names) {
		Arrays.stream(names).forEach(System.out::println);
	}

	public void method4(List<Integer> numbers) {

		for (Integer num : numbers) {
			System.out.println(num);
		}

	}
}
