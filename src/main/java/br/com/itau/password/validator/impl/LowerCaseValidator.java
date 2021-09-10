package br.com.itau.password.validator.impl;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

import br.com.itau.password.validator.Validator;

/** Password lower case validator */
public class LowerCaseValidator implements Validator {

	/** @inheritDoc */
	@Override
	public void validate(String text) {
		
		if(isNoneBlank(text) && !text.matches(".*[a-z].*")) {
			throw new IllegalArgumentException("At least 1 lower case letter is required");
		}
	}
}
