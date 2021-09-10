package br.com.itau.password.validator.impl;

import java.util.List;

import br.com.itau.password.config.ValidationConfig;
import br.com.itau.password.model.ValidationResponse;
import br.com.itau.password.validator.Validator;
import br.com.itau.password.validator.ValidatorEngine;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Default {@link ValidatorEngine}
 */
@Slf4j
public class DefaultValidatorEngine implements ValidatorEngine {

	/** A {@link List} of {@link Validator} */
	@Getter
	private List<Validator> validators;
	
	/**
	 * Default constructor
	 * @param validators to apply
	 */
	public DefaultValidatorEngine(List<Validator> validators) {
		this.validators = validators;
	}
	
	/** 
	 * Validate password with all configured validators
	 * To configure, see {@link ValidationConfig} 
	 */
	public ValidationResponse validateAll(String password) {
		
		ValidationResponse response = new ValidationResponse();
		
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
