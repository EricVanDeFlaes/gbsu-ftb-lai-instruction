package com.kata.gbsuftblai.services;

import org.springframework.stereotype.Component;

@Component
public class GbsuFtbLaiService {

	public String convertNumber(int number) {
		String strNumber = String.valueOf(number);
		StringBuilder result = new StringBuilder();
		if (number % 3 == 0) result.append("Gbsu");
		if (number % 5 == 0) result.append("Ftb");
		for (char car: strNumber.toCharArray()) {
			switch (car) {
				case '3':
					result.append("Gbsu");
					break;
				case '5':
					result.append("Ftb");
					break;
				case '7':
					result.append("Lai");
					break;
				default:
					break;
			}
		}
		if (result.length() == 0) return strNumber;
		return result.toString();
    }

}