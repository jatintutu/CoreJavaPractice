package core.java.collections;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListPractice {

	@Test
	public void createList() {
		List<String> list = new ArrayList<>();
		list.add("Jack");
		list.add("Tom");
		list.add("Tim");
		System.out.println(list);
	}

	@Test
	public void iterateList() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);

		//method1
		for (Integer num : numbers) {
			System.out.println(num);
		}

		//method 2
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}

		//method 3 jdk 8
		numbers.stream().forEach(num -> {
			System.out.println(num);
		});
	}

	@Test
	public void removeFromList() {
		List<Double> numbers = new ArrayList<>();
		numbers.add(1.23);
		numbers.add(2.45);
		numbers.add(3D);
		System.out.println(numbers);

		numbers.remove(2.45);
		System.out.println(numbers);
		numbers.remove(0);
		System.out.println(numbers);
	}
}
