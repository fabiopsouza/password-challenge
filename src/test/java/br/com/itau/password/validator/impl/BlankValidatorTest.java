package br.com.itau.password.validator.impl;

import org.junit.Before;
import org.junit.Test;

/** Tests for {@link BlankValidator} */
public class BlankValidatorTest {

	/** Tests for {@link BlankValidator} */
	private BlankValidator validator;
	
	/** Test setup */
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
	public void shouldNoException_whenParameter_isFilled() {
		validator.validate("test");
	}
}
