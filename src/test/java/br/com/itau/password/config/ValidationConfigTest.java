package br.com.itau.password.config;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.itau.password.validator.Validator;
import br.com.itau.password.validator.impl.BlankValidator;
import br.com.itau.password.validator.impl.DigitValidator;
import br.com.itau.password.validator.impl.LengthValidator;
import br.com.itau.password.validator.impl.LowerCaseValidator;
import br.com.itau.password.validator.impl.RepeatedCharactersValidator;
import br.com.itau.password.validator.impl.SpecialCharacterValidator;
import br.com.itau.password.validator.impl.UpperCaseValidator;
import br.com.itau.password.validator.impl.WhiteSpaceValidator;

/** Tests for {@link ValidationConfig} */
public class ValidationConfigTest {

	/** A {@link ValidationConfig} instance */
	private ValidationConfig config;
	
	/** Test setup */
	@Before
	public void testSetup() {
		config = new ValidationConfig();
	}
	
	@Test
	public void hasBlankValidator() {
		List<Validator> validators = config.validationEngine().getValidators();
		boolean hasBlankValidator = validators.stream().anyMatch(validator -> validator instanceof BlankValidator);
		assertTrue(hasBlankValidator);
	}
	
	@Test
	public void hasDigitValidator() {
		List<Validator> validators = config.validationEngine().getValidators();
		boolean hasDigitValidator = validators.stream().anyMatch(validator -> validator instanceof DigitValidator);
		assertTrue(hasDigitValidator);
	}
	
	@Test
	public void hasLengthValidator() {
		List<Validator> validators = config.validationEngine().getValidators();
		boolean hasLengthValidator = validators.stream().anyMatch(validator -> validator instanceof LengthValidator);
		assertTrue(hasLengthValidator);
	}
	
	@Test
	public void hasLowerCaseValidator() {
		List<Validator> validators = config.validationEngine().getValidators();
		boolean hasLowerCaseValidator = validators.stream().anyMatch(validator -> validator instanceof LowerCaseValidator);
		assertTrue(hasLowerCaseValidator);
	}
	
	@Test
	public void hasUpperCaseValidator() {
		List<Validator> validators = config.validationEngine().getValidators();
		boolean hasUpperCaseValidator = validators.stream().anyMatch(validator -> validator instanceof UpperCaseValidator);
		assertTrue(hasUpperCaseValidator);
	}
	
	@Test
	public void hasRepeatedCharactersValidator() {
		List<Validator> validators = config.validationEngine().getValidators();
		boolean hasRepeatedCharactersValidator = validators.stream().anyMatch(validator -> validator instanceof RepeatedCharactersValidator);
		assertTrue(hasRepeatedCharactersValidator);
	}
	
	@Test
	public void hasSpecialCharacterValidator() {
		List<Validator> validators = config.validationEngine().getValidators();
		boolean hasSpecialCharacterValidator = validators.stream().anyMatch(validator -> validator instanceof SpecialCharacterValidator);
		assertTrue(hasSpecialCharacterValidator);
	}
	
	@Test
	public void hasWhiteSpaceValidator() {
		List<Validator> validators = config.validationEngine().getValidators();
		boolean hasWhiteSpaceValidator = validators.stream().anyMatch(validator -> validator instanceof WhiteSpaceValidator);
		assertTrue(hasWhiteSpaceValidator);
	}
}
