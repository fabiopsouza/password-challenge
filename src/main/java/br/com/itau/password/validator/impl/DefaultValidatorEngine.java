package br.com.itau.password.validator.impl;

import java.util.List;

import br.com.itau.password.model.PasswordResponse;
import br.com.itau.password.validator.Validator;
import br.com.itau.password.validator.ValidatorEngine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultValidatorEngine implements ValidatorEngine {

	private List<Validator> validators;
	
	public DefaultValidatorEngine(List<Validator> validators) {
		this.validators = validators;
	}
	
	public PasswordResponse validateAll(String password) {
		
		PasswordResponse response = new PasswordResponse();
		
		validators.forEach(validator -> { 
			
			try {
				validator.validate(password);
			}
			catch(IllegalArgumentException e) {
				log.warn("Input {} has validation error: {}", password, e.getMessage());
				response.addReason(e.getMessage());
			}
		});
		
		return response; 
	}
}
