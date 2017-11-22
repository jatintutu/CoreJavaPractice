package core.java.excption.handling;

import org.junit.Test;

public class ExceptionHandlingSubPractice extends ExceptionHandlingPractice {

	/*@Test
	@Override
	public void throwException3() throws Exception {
		throw new RuntimeException("Run Time Exception");
	}*/

	@Test
	@Override
	public void throwException3() throws RuntimeException {
		throw new RuntimeException("Run Time Exception");
	}
}
