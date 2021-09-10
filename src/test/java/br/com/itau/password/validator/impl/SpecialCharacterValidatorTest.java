package br.com.itau.password.validator.impl;

import org.junit.Before;
import org.junit.Test;

/** Tests for {@link SpecialCharacterValidator} */
public class SpecialCharacterValidatorTest {

	/** Tests for {@link SpecialCharacterValidator} */
	private SpecialCharacterValidator validator;
	
	/** Test setup */
	@Before
	public void testSetup() {
		validator = new SpecialCharacterValidator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_doesNotHasSpecialCharacter() {
		validator.validate("teste");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameter_hasSpecialCharacter() {
		validator.validate("'¨=`´{}[]?/|\\/;:><,.");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasExclamation() {
		validator.validate("!teste");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasAtSign() {
		validator.validate("t@este");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasHashTag() {
		validator.validate("te#ste");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasDollarSign() {
		validator.validate("tes$te");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasPercentageSign() {
		validator.validate("test%e");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasComercialE() {
		validator.validate("teste&");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasAsterisk() {
		validator.validate("*teste");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasLeftParentheses() {
		validator.validate("t(este");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasRightParentheses() {
		validator.validate("te)ste");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasHyphen() {
		validator.validate("tes-te");
	}
	
	@Test
	public void shouldNoException_whenParameter_hasSumSign() {
		validator.validate("test+e");
	}
	
	@Test
	public void shouldNoException_whenParameter_isNull() {
		validator.validate(null);
	}
}
