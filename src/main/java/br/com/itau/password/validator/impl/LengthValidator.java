package br.com.itau.password.validator.impl;

import static br.com.itau.password.util.Constants.MINIMUM_PASSWORD_LENGTH;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;

import br.com.itau.password.validator.Validator;

public class LengthValidator implements Validator {

	@Override
	public void validate(String text) {
		
		if(isNoneBlank(text) && text.length() < MINIMUM_PASSWORD_LENGTH) {
			throw new IllegalArgumentException("Argument length is invalid");
		}
	}
}
