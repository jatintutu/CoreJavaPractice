package core.java.loops;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WhileLoop {
	@Test
	public void loop10Numbers() {

		int i = 0;
		while (i < 10) {
			System.out.println("i :" + i);
			i++;
		}
	}

	@Test
	public void stringArray() {
		int i = 0;
		String[] names = { "jack", "john", "jill", "scott", "matt", "tim", "Ted" };
		while (i < names.length) {
			System.out.println("name1 : " + names[i]);
			i++;
		}

	}

	@Test
	public void loopStringList() {
		List<String> names = Arrays.asList("jack", "john", "jill", "scott", "matt", "tim", "Ted");
		int i = 0;
		while (i < names.size()) {
			System.out.println("name2 : " + names.get(i));
			i++;
		}
	}

	@Test
	public void listOfIntegers() {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60);
		int i = 0;
		while (i < numbers.size()) {

			System.out.println("numbers1 : " + numbers.get(i));
			i++;
		}
	}
}
