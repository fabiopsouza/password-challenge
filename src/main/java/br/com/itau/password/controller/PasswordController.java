package br.com.itau.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.itau.password.model.PasswordResponse;
import br.com.itau.password.validator.impl.DefaultValidatorEngine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PasswordController {

	@Autowired
	private DefaultValidatorEngine validator;
	
	@PostMapping("/password/validate")
	public ResponseEntity<PasswordResponse> validatePassword(@RequestBody (required=false) String password) {
		
		try {
			PasswordResponse response = validator.validateAll(password);
			return ResponseEntity.ok(response);
		}
		catch (Exception e) {
			
			log.error(e.getMessage());
			PasswordResponse response = new PasswordResponse(e.getMessage());
			return ResponseEntity.badRequest().body(response );
		}
	}
}
