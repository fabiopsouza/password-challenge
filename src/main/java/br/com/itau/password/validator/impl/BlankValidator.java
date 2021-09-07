package br.com.itau.password.validator.impl;

import static org.apache.commons.lang3.StringUtils.isBlank;

import br.com.itau.password.validator.Validator;

public class BlankValidator implements Validator {

	@Override
	public void validate(String text) {
		
		if(isBlank(text)) {
			throw new IllegalArgumentException("Argument is null, empty or white space");
		}
	}
}
