package br.com.itau.password.validator.impl;

import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.Set;

import br.com.itau.password.validator.Validator;

/** Password repeated charaters validator */
public class RepeatedCharactersValidator implements Validator {

	/** @inheritDoc */
	@Override
	public void validate(String text) {

		if(isBlank(text))
			return;
		
		Set<Character> chars = text.chars()
				.mapToObj(character -> (char) character).collect(toSet());
		
		if(text.length() != chars.size()) {
			throw new IllegalArgumentException("Repeated character is invalid");
		}
	}
}
