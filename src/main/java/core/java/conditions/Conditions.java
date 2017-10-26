package core.java.conditions;

import org.junit.Test;

public class Conditions {

	@Test
	public void ifCondition() {
		boolean flag = true;
		if (flag) {
			System.out.println("boolean : " + flag);
		}
	}

	@Test
	public void ifElseCondition() {
		boolean flag = true;

		if (!flag) {
			System.out.println("iside if");
		} else {
			System.out.println("inside else");
		}
	}

	@SuppressWarnings("unused")
	@Test
	public void tertiaryCondition() {
		boolean flag = 10 > 20 ? true : false;
		System.out.println("flag is : " + flag);

		flag = 10 < 20 ? true : false;
		System.out.println("flag is : " + flag);
	}

}