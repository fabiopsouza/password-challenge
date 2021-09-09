package br.com.itau.password.validator.impl;

import static br.com.itau.password.util.Constants.MINIMUM_PASSWORD_LENGTH;

import br.com.itau.password.validator.Validator;

public class LengthValidator implements Validator {

	@Override
	public void validate(String text) {
		
		if(text.length() < MINIMUM_PASSWORD_LENGTH) {
			throw new IllegalArgumentException("Argument length is invalid");
		}
	}
}
