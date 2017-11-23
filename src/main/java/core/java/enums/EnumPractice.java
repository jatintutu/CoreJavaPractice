package core.java.enums;

import org.junit.Test;

import core.java.enums.model.DaysEnum;
import core.java.enums.model.DaysEnum2;

public class EnumPractice {

	@Test
	public void accessEnum() {
		DaysEnum monday = DaysEnum.MONDAY;
		System.out.println(monday);
	}

	@Test
	public void enumInIf() {
		DaysEnum monday = DaysEnum.MONDAY;
		DaysEnum tuesday = DaysEnum.TUESDAY;

		if (DaysEnum.MONDAY == monday) {
			System.out.println("Inside If block");
		} else {
			System.out.println("Tuesday : " + tuesday);
		}
	}

	@Test
	public void enumInswitch() {
		DaysEnum monday = DaysEnum.MONDAY;
		switch (monday) {
		case MONDAY:
			System.out.println("monday");
			break;
		case TUESDAY:
			System.out.println("tuesday");
			break;
		default:
			break;
		}
	}

	@Test
	public void iterateEnum() {
		DaysEnum[] daysEnumArray = DaysEnum.values();
		for (DaysEnum day : daysEnumArray) {
			System.out.println(day);
		}
	}

	@Test
	public void iterateEnum2() {
		DaysEnum2[] daysEnum2Array = DaysEnum2.values();
		for (DaysEnum2 day : daysEnum2Array) {
			System.out.println(day.getNumber());
		}
	}
}
