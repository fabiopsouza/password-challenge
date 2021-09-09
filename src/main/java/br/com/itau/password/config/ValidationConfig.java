package br.com.itau.password.config;

import static java.util.Arrays.asList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.password.validator.ValidatorEngine;
import br.com.itau.password.validator.impl.BlankValidator;
import br.com.itau.password.validator.impl.DigitValidator;
import br.com.itau.password.validator.impl.LengthValidator;
import br.com.itau.password.validator.impl.LowerCaseValidator;
import br.com.itau.password.validator.impl.RepeatedCharactersValidator;
import br.com.itau.password.validator.impl.SpecialCharacterValidator;
import br.com.itau.password.validator.impl.UpperCaseValidator;

@Configuration
public class ValidationConfig {

	@Bean
	public ValidatorEngine validationEngine() {
		return new ValidatorEngine(asList(
				new BlankValidator(), 
				new LengthValidator(),
				new DigitValidator(),
				new LowerCaseValidator(),
				new UpperCaseValidator(),
				new SpecialCharacterValidator(),
				new RepeatedCharactersValidator()
			));
	}
}
