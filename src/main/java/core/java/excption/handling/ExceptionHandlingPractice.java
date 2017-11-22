package core.java.excption.handling;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class ExceptionHandlingPractice {

	/*
	 * Exception is an event/object which occurs during the execution of the program
	 * that disrupts the execution of normal program flow.
	 */
	@Test
	public void tryCatchBlock() {
		try {
			int value = 10 / 0;
			System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void multipleCatchBlocks() {
		try {
			int value = 10 / 0;
			System.out.println(value);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void catchWithMultipleExceptions() {
		try {
			int value = 10 / 0;
			System.out.println(value);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void tryWithFinally() {
		try {
			int value = 10;
			System.out.println(value);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Inside finally block:");
		}

	}

	@Test
	public void tryWithFinally2() {
		try {
			int value = 10 / 0;
			System.out.println(value);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Inside finally block:");
		}

	}

	@Test
	public void tryWithFinally3() {
		try {
			int value = 10 / 0;
			System.out.println(value);
		} finally {
			System.out.println("Inside finally block:");
		}
	}

	@Test
	public void throwException() {
		throw new RuntimeException("Run Time Exception");
	}

	@Test
	public void throwException2() throws Exception {
		throw new Exception("Run Time Exception");
	}

	@Test
	public void throwException3() throws RuntimeException {
		throw new RuntimeException("Run Time Exception");
	}

	@Test
	public void tryWithResource() throws IOException {
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream("file1.txt");
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			if (null != inputStream) {
				inputStream.close();
			}
			if (null != bufferedReader) {
				bufferedReader.close();
			}
		}
	}

	/**
	 * resource class must implement {@link Closeable} or {@link AutoCloseable} interfaces
	 * {@link ExceptionHandlingSubPractice#throwException3()}
	 * 
	 */
	@Test
	public void tryWithResource2() throws IOException {
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("file1.txt");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

	/**
	 * resource class must implement {@link Closeable} or {@link AutoCloseable} interfaces
	 * {@link ExceptionHandlingSubPractice#throwException3()}
	 * 
	 */
	@Test
	public void tryWithResource3() {
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("file1.txt");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
