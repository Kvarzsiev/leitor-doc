package com.leitordoc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	public static String toNumbersOnly (String input) {
		String output = input.replaceAll(" ", "");
		output = output.replaceAll(".", "");
		output = output.replaceAll("-", "");
		output = output.replaceAll("/", "");
		return output;
	}
}
