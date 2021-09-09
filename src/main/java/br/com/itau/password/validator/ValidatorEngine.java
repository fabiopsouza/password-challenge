package br.com.itau.password.validator;

import br.com.itau.password.model.PasswordResponse;

public interface ValidatorEngine {
	
	public PasswordResponse validateAll(String password);
}
