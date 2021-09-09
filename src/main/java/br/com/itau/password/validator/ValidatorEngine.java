package br.com.itau.password.validator;

import java.util.List;

public class ValidatorEngine {

	private List<Validator> validators;
	
	public ValidatorEngine(List<Validator> validators) {
		this.validators = validators;
	}
	
	public void validateAll(String password) {
		validators.forEach(validator -> validator.validate(password));
	}
}
