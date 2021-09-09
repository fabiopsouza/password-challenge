package br.com.itau.password.validator.impl;

import br.com.itau.password.validator.Validator;

public class LowerCaseValidator implements Validator {

	@Override
	public void validate(String text) {
		
		if(!text.matches(".*[a-z].*")) {
			throw new IllegalArgumentException("At least 1 lower case letter is required");
		}
	}
}
