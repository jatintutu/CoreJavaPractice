package core.java.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import core.java.reflection.model.ReflectionModel1;

public class ReflectionPractice {

	@Test
	public void classObject() {
		Class<ReflectionModel1> klass = ReflectionModel1.class;
		System.out.println(klass);
	}

	@Test
	public void classObject2() {
		try {
			Class<?> klass = Class.forName("core.java.reflection.model.ReflectionModel1");
			System.out.println(klass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void classObject3() {
		ReflectionModel1 reflectionModel1 = new ReflectionModel1();
		Class<?> klass = reflectionModel1.getClass();
		// To get package
		Package package1 = klass.getPackage();
		System.out.println(package1);
		System.out.println(klass);
	}

	@Test
	public void createInstance() {
		try {
			Class<?> klass = Class.forName("core.java.reflection.model.ReflectionModel1");
			Object obj = klass.newInstance();
			System.out.println(obj);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createInstance2() {
		try {
			Class<?> klass = Class.forName("core.java.reflection.model.ReflectionModel1");
			Constructor<?> constructor = klass.getConstructor(String.class);
			Object obj = constructor.newInstance("Jack");
			System.out.println(obj);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getSuperClass() {
		Class<ReflectionModel1> klass = ReflectionModel1.class;
		Class<?> klass1 = klass.getSuperclass();
		System.out.println(klass1);
	}

	@Test
	public void getInterfaces() {
		Class<ReflectionModel1> klass = ReflectionModel1.class;
		Class<?>[] klass1 = klass.getInterfaces();
		System.out.println(klass1);
		for (Class<?> str : klass1) {
			System.out.println(str);
		}
	}

	@Test
	public void createInstance3() {
		try {
			Class<ReflectionModel1> klass = ReflectionModel1.class;
			Constructor<?> constructor = klass.getConstructor(int.class);
			Object obj = constructor.newInstance(25);
			System.out.println(obj);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void callMethodWithZeroArgument() {

		try {
			Class<ReflectionModel1> klass = ReflectionModel1.class;
			Object obj = klass.newInstance();
			Method method = klass.getMethod("method1");
			method.invoke(obj);

		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void callMethodWithStringArgument() {

		try {
			Class<ReflectionModel1> klass = ReflectionModel1.class;
			Object obj = klass.newInstance();
			Method method;
			method = klass.getMethod("method2", String.class);
			method.invoke(obj, "jack");
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void callMethodWithStringArray() {

		try {
			Class<ReflectionModel1> klass = ReflectionModel1.class;
			Object obj = klass.newInstance();
			Method method = klass.getMethod("method3", Array.newInstance(String.class, 1).getClass());
			String[] str = { "jack", "john", "jill" };
			method.invoke(obj, new Object[] { str });

		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| NegativeArraySizeException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void callMethodWithListArgument() {

		try {
			Class<ReflectionModel1> klass = ReflectionModel1.class;
			Object obj = klass.newInstance();
			Method method = klass.getMethod("method4", List.class);
			List<Integer> num = Arrays.asList(10, 20, 30, 40, 50, 60);
			method.invoke(obj, num);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createStringArray() {
		Object obj = Array.newInstance(String.class, 5);
		Array.set(obj, 0, "sam");
		System.out.println(Array.get(obj, 0));
	}
}