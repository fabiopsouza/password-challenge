package br.com.itau.password.validator.impl;

import org.junit.Before;
import org.junit.Test;

/** Tests for {@link UpperCaseValidator} */
public class UpperCaseValidatorTest {

	/** Tests for {@link UpperCaseValidator} */
	private UpperCaseValidator validator;
	
	/** Test setup */
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
	
	@Test
	public void shouldNoException_whenParameter_isNull() {
		validator.validate(null);
	}
}
