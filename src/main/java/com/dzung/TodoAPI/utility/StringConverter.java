package com.dzung.TodoAPI.utility;

import org.springframework.stereotype.Component;

public class StringConverter {
	// Example: startDate -> start_Date 
	public static String convertCamelToUnderScore(String input) {
		String regex = "(?=[A-Z][a-z])";
		return input.replaceAll(regex, "_");
	}
}