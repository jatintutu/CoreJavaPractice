package core.java.loops;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ForLoop {

	@Test
	public void loopTenNumbers() {
		for (int i = 0; i < 10; i++) {
			System.out.println("i: " + i);

		}
	}

	@Test
	public void loopStringArray() {
		String[] names = { "jack", "john", "jill", "scott", "matt", "tim", "Ted" };

		// method 1
		for (int i = 0; i < names.length; i++) {
			System.out.println("name1 :" + names[i]);
		}

		// method 2
		for (String str : names) {
			System.out.println("name2 : " + str);
		}
	}

	@Test
	public void loopStringList() {
		List<String> names = Arrays.asList("jack", "john", "jill", "scott", "matt", "tim", "Ted");

		// traditions for loop
		for (int i = 0; i < names.size(); i++) {
			System.out.println("name3 :" + names.get(i));
		}

		// for each loop
		for (String str : names) {
			System.out.println("name 2:" + str);
		}

	}

	@Test
	public void loopIntegerList() {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60);

		// for each loop
		for (Integer num : numbers) {
			System.out.println("numbers1:" + num);

		}

	}

}
