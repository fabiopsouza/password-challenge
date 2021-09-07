package br.com.itau.password.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.password.validator.Validator;
import br.com.itau.password.validator.ValidatorEngine;
import br.com.itau.password.validator.impl.BlankValidator;
import br.com.itau.password.validator.impl.LengthValidator;

@Configuration
public class ValidationConfiguration {
	
	@Bean
	public ValidatorEngine validationEngine() 
	{
		Set<Validator> validators = new HashSet<>();
		validators.add(new BlankValidator());
		validators.add(new LengthValidator());
		
		return new ValidatorEngine(validators);
	}
}
