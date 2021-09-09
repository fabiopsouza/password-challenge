package br.com.itau.password.validator.impl;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

import br.com.itau.password.validator.Validator;

public class SpecialCharacterValidator implements Validator {

	@Override
	public void validate(String text) {
		
		if(isNoneBlank(text) && !text.matches(".*[!@#$%^&*()\\-+].*")) {
			throw new IllegalArgumentException("At least 1 special character is required");
		}
	}
}
