package br.com.itau.password.validator.impl;

import org.junit.Before;
import org.junit.Test;

public class UpperCaseValidatorTest {

	private UpperCaseValidator validator;
	
	@Before
	public void testSetup() {
		validator = new UpperCaseValidator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_doesNotHasUpperCase() {
		validator.validate("teste");
	}
	
	@Test
	public void shouldNoException_whenParameter_isFullUpperCase() {
		validator.validate("TESTE");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasUpperCase() {
		validator.validate("teSte");
	}
}
