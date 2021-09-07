package br.com.itau.password.validator.impl;

import static br.com.itau.password.util.Constants.MINIMUM_PASSWORD_LENGTH;

import org.junit.Before;
import org.junit.Test;

public class LengthValidatorTest {

	private LengthValidator validator;
	
	@Before
	public void testSetup() {
		validator = new LengthValidator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenParameterLength_isSmallerThanExpected() {
		validator.validate(generateStringWithLength(MINIMUM_PASSWORD_LENGTH - 1));
	}
	
	@Test
	public void shouldNoException_whenParameterLength_isExpected() {
		validator.validate(generateStringWithLength(MINIMUM_PASSWORD_LENGTH));
	}
	
	@Test
	public void shouldNoException_whenParameterLength_isBiggerThenExpected() {
		validator.validate(generateStringWithLength(MINIMUM_PASSWORD_LENGTH + 1));
	}
	
	private String generateStringWithLength(int size) {
		
		StringBuilder stringBuilder = new StringBuilder();
				
		int index = 0;
		while(index++ < size)
			stringBuilder.append("s");
		
		return stringBuilder.toString();
	}
}
