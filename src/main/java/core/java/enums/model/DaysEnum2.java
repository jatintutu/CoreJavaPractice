package core.java.enums.model;

public enum DaysEnum2 {

	MONDAY(10), TUESDAY(20), WEDNESDAY(30), THRUSDAY(40), FRIDAY(50), SATURDAY(60), SUNDAY(70);

	private int number;

	private DaysEnum2(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
