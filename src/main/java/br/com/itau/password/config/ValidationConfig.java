package br.com.itau.password.config;

import static java.util.Arrays.asList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.password.validator.ValidatorEngine;
import br.com.itau.password.validator.impl.BlankValidator;
import br.com.itau.password.validator.impl.DefaultValidatorEngine;
import br.com.itau.password.validator.impl.DigitValidator;
import br.com.itau.password.validator.impl.LengthValidator;
import br.com.itau.password.validator.impl.LowerCaseValidator;
import br.com.itau.password.validator.impl.RepeatedCharactersValidator;
import br.com.itau.password.validator.impl.SpecialCharacterValidator;
import br.com.itau.password.validator.impl.UpperCaseValidator;
import br.com.itau.password.validator.impl.WhiteSpaceValidator;

/** Validation configurations */
@Configuration
public class ValidationConfig {

	/**
	 * Create a {@link ValidationEngine}
	 */
	@Bean
	public ValidatorEngine validationEngine() {
		
		return new DefaultValidatorEngine(asList(
				new BlankValidator(), 
				new LengthValidator(),
				new DigitValidator(),
				new LowerCaseValidator(),
				new UpperCaseValidator(),
				new SpecialCharacterValidator(),
				new RepeatedCharactersValidator(),
				new WhiteSpaceValidator()
			));
	}
}
