package core.java.loops;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DoWhileLoop {

	@Test
	public void iterate10Numbers() {
		int i = 0;
		do {
			System.out.println("i: " + i);
			i++;
		} while (i < 10);

	}

	@Test
	public void iterateStringArray() {
		String[] names = { "jack", "john", "jill", "scott", "matt", "tim", "Ted" };
		int i = 0;
		do {
			System.out.println("names1 : " + names[i]);
			i++;
		} while (i < names.length);
	}

	@Test
	public void listOfString() {

		List<String> names = Arrays.asList("jack", "john", "jill", "scott", "matt", "tim", "Ted");
		int i = 0;
		do {
			System.out.println("names :" + names.get(i));
			i++;
		} while (i < names.size());
	}

	@Test
	public void loopIntegerList() {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60);
		int i = 0;
		do {
			System.out.println("numbers: " + numbers.get(i));
			i++;
		} while (i < numbers.size());
	}
}