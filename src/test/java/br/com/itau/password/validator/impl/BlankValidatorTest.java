package br.com.itau.password.validator.impl;

import org.junit.Before;
import org.junit.Test;

public class BlankValidatorTest {

	private BlankValidator validator;
	
	@Before
	public void testSetup() {
		validator = new BlankValidator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_isNull() {
		validator.validate(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_isEmpty() {
		validator.validate("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_isWhiteSpace() {
		validator.validate(" ");
	}
	
	@Test
	public void shouldNoException_whenParameter_isOk() {
		validator.validate("test");
	}
}
