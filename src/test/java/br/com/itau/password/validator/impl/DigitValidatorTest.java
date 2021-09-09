package br.com.itau.password.validator.impl;

import org.junit.Before;
import org.junit.Test;

public class DigitValidatorTest {

	private DigitValidator validator;
	
	@Before
	public void testSetup() {
		validator = new DigitValidator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_doesNotHasDigit() {
		validator.validate("teste");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasDigitAtStart() {
		validator.validate("1teste");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasDigitAtMiddle() {
		validator.validate("teste10teste");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasDigitAtEnd() {
		validator.validate("teste100");
	}
}
