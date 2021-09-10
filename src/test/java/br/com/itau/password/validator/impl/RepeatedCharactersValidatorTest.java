package br.com.itau.password.validator.impl;

import org.junit.Before;
import org.junit.Test;

/** Tests for {@link RepeatedCharactersValidator} */
public class RepeatedCharactersValidatorTest {

	/** Tests for {@link RepeatedCharactersValidator} */
	private RepeatedCharactersValidator validator;
	
	/** Test setup */
	@Before
	public void testSetup() {
		validator = new RepeatedCharactersValidator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_hasRepeatedCharacter() {
		validator.validate("abcdde");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_hasRepeatedSpecialCharacter() {
		validator.validate("a!bcde!");
	}
	
	@Test
	public void shouldNoException_whenParameter_doesNotHasRepeatedCharacter() {
		validator.validate("abcde");
	}
	
	@Test
	public void shouldNoException_whenParameter_isNull() {
		validator.validate(null);
	}
}
