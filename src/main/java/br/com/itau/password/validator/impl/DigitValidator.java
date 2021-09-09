package br.com.itau.password.validator.impl;

import br.com.itau.password.validator.Validator;

public class DigitValidator implements Validator {

	@Override
	public void validate(String text) {
		
		if(!text.matches(".*\\d.*")) {
			throw new IllegalArgumentException("At least 1 digit is required");
		}
	}
}
