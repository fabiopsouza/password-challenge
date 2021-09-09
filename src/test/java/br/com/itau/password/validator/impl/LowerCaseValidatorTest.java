package br.com.itau.password.validator.impl;

import org.junit.Before;
import org.junit.Test;

public class LowerCaseValidatorTest {

	private LowerCaseValidator validator;
	
	@Before
	public void testSetup() {
		validator = new LowerCaseValidator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_doesNotHasLowerCase() {
		validator.validate("TESTE");
	}
	
	@Test
	public void shouldNoException_whenParameter_isFullLowerCase() {
		validator.validate("teste");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasLowerCase() {
		validator.validate("TEsTE");
	}
	
	@Test
	public void shouldNoException_whenParameter_isNull() {
		validator.validate(null);
	}
}
