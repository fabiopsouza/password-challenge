package br.com.itau.password.validator.impl;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

import br.com.itau.password.validator.Validator;

/** Password white space validator */
public class WhiteSpaceValidator implements Validator {

	/** @inheritDoc */
	@Override
	public void validate(String text) {
		
		if(isNoneBlank(text) && text.matches(".*[ ].*")) {
			throw new IllegalArgumentException("White space is invalid");
		}
	}
}
