/**
 * Padding.java
 */
package org.com1028.project.mg00929.football_classes;

/**
 * This class has the only functionality of padding strings in order for them to
 * match a specific format.
 * 
 * @author Milen Georgiev
 *
 */
public class Padding {
	/**
	 * Pads the string on its beginning.
	 * @param inputString
	 * @param length of the final string
	 * @return the new padded string
	 */
	public static String padLeft(String inputString, int length) {
		if (inputString.length() >= length) {
			return inputString;
		}
		StringBuilder sb = new StringBuilder();
		while (sb.length() < length - inputString.length()) {
			sb.append(' ');
		}
		sb.append(inputString);

		return sb.toString();
	}

	/**
	 * Pads the string on its end.
	 * @param inputString
	 * @param length of the final string
	 * @return the new padded string
	 */
	public static String padRight(String inputString, int length) {
		if (inputString.length() >= length) {
			return inputString;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(inputString);

		while (sb.length() < length) {
			sb.append(' ');
		}

		return sb.toString();
	}
}
