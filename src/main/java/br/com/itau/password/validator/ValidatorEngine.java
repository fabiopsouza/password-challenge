package br.com.itau.password.validator;

import java.util.List;

import br.com.itau.password.model.PasswordResponse;

public interface ValidatorEngine {
	
	public List<Validator> getValidators();
	
	public PasswordResponse validateAll(String password);
}
