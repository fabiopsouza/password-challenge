package br.com.itau.password.validator;

import java.util.Set;

public class ValidatorEngine {

	private Set<Validator> validators;
	
	public ValidatorEngine(Set<Validator> validators) {
		this.validators = validators;
	}
	
	public void validateAll(String password) {
		validators.forEach(validator -> validator.validate(password));
	}
}
