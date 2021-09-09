package br.com.itau.password.validator.impl;

import br.com.itau.password.validator.Validator;

public class UpperCaseValidator implements Validator {

	@Override
	public void validate(String text) {
		
		if(!text.matches(".*[A-Z].*")) {
			throw new IllegalArgumentException("At least 1 upper case letter is required");
		}
	}
}
