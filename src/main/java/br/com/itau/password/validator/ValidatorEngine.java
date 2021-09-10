package br.com.itau.password.validator;

import java.util.List;

import br.com.itau.password.model.ValidationResponse;

/** Describe a password validation engine */
public interface ValidatorEngine {
	
	/** @return {@link List} of {@link Validator} */
	public List<Validator> getValidators();
	
	/**
	 * @param password to validate
	 * @return {@link ValidationResponse} validation response
	 */
	public ValidationResponse validateAll(String password);
}
