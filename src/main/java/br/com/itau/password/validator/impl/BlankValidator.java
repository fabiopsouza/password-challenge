package br.com.itau.password.validator.impl;

import static org.apache.commons.lang3.StringUtils.isBlank;

import br.com.itau.password.validator.Validator;

/** Null, Empty or White space validator */
public class BlankValidator implements Validator {

	/** @inheritDoc */
	@Override
	public void validate(String text) {
		
		if(isBlank(text)) {
			throw new IllegalArgumentException("Password argument is required");
		}
	}
}
