package br.com.itau.password.validator.impl;

import static java.util.stream.Collectors.toSet;

import java.util.Set;

import br.com.itau.password.validator.Validator;

public class RepeatedCharactersValidator implements Validator {

	@Override
	public void validate(String text) {

		Set<Character> chars = text.chars()
				.mapToObj(character -> (char) character).collect(toSet());
		
		if(text.length() != chars.size()) {
			throw new IllegalArgumentException("Argument has repeated character");
		}
	}
}