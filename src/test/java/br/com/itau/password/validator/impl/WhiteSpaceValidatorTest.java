package br.com.itau.password.validator.impl;

import org.junit.Before;
import org.junit.Test;

public class WhiteSpaceValidatorTest {

	private WhiteSpaceValidator validator;
	
	@Before
	public void testSetup() {
		validator = new WhiteSpaceValidator();
	}
	
	@Test
	public void shouldNoException_whenParameter_doesNotHasWhiteSpace() {
		validator.validate("teste");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_hasWhiteSpaceAtStart() {
		validator.validate(" teste");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_hasWhiteSpaceAtMiddle() {
		validator.validate("te ste");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_hasWhiteSpaceAtEnd() {
		validator.validate("teste ");
	}
	
	@Test
	public void shouldNoException_whenParameter_isNull() {
		validator.validate(null);
	}
}
