package core.java.strings;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.junit.Test;

public class StringPractice {

	@Test
	public void stringLength() {
		String s1 = "Hello";
		System.out.println("length : " + s1.length());

	}

	@Test
	public void stringEquals() {
		String s1 = "Hello";
		String s2 = new String("Hello");
		String s3 = "Hello";

		boolean isEqual = (s1 == s2);
		System.out.println("isEqual: " + isEqual);

		boolean isEqual2 = (s1 == s3);
		System.out.println("isEqual2 : " + isEqual2);
	}

	@Test
	public void getByteArrayFromString() {
		String s1 = "Hello world";

		// method 1
		byte[] byteArray1 = s1.getBytes();
		System.out.println("byteArray1 : " + byteArray1);
		System.out.println(Arrays.toString(byteArray1));
		System.out.println(new String(byteArray1));

		// method 2
		byte[] byteArray2 = s1.getBytes(Charset.forName("UTF-8"));
		System.out.println("byteArray2: " + byteArray2);
		System.out.println("Arrays.toString(byteArray2): " + Arrays.toString(byteArray2));

		// method 3 - from java 7
		byte[] byteArray3 = s1.getBytes(StandardCharsets.UTF_8);
		System.out.println("byteArray3: " + byteArray3);
		System.out.println("Arrays.toString(byteArray3): " + Arrays.toString(byteArray3));

	}

	@Test
	public void divideString() {
		String s1 = "Hello-Java-World-Welcome-to-Java";
		String[] strs = s1.split("-");
		for (String str : strs) {
			System.out.println("strs : " + str);
		}
	}

	@Test
	public void subString() {
		String s1 = "Hello world";
		String str = s1.substring(1, 9);
		System.out.println("Substring : " + str);

		String str1 = s1.substring(6);
		System.out.println(" untill end of string :" + str1);

	}

	@Test
	public void convertCase() {
		String s1 = "Hello World";
		String str = s1.toLowerCase();
		System.out.println(str);

		String str1 = s1.toUpperCase();
		System.out.println(str1);
	}

	@Test
	public void capitalize() {
		String s1 = "hello world";
		String h = s1.substring(0, 1);
		System.out.println(h);

		String w = s1.substring(6, 7);
		System.out.println(w);

		String H = h.toUpperCase();
		String W = w.toUpperCase();

		String ello = s1.substring(1, 6);
		String orld = s1.substring(7);

		String finalString = H + ello + W + orld;
		System.out.println(finalString);

		// method 2
		String[] strs = s1.split(" ");
		String firstWordCapitalize = strs[0].substring(0, 1).toUpperCase() + strs[0].substring(1);
		String secondWordCapitalize = strs[1].substring(0, 1).toUpperCase() + strs[1].substring(1);
		System.out.println(firstWordCapitalize + ", " + secondWordCapitalize);

		// method 3
		StringBuilder finalString2 = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			finalString2.append(strs[i].substring(0, 1).toUpperCase() + strs[i].substring(1) + " ");
		}
		System.out.println(finalString2);
	}

	@Test
	public void printAllSubStrings() {
		String s1 = "Helloworld";

	}
}
