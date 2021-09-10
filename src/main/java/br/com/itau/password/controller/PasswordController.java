package br.com.itau.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.itau.password.model.ValidationResponse;
import br.com.itau.password.validator.ValidatorEngine;
import lombok.extern.slf4j.Slf4j;

/** Password API Controller */
@Slf4j
@Controller
public class PasswordController {

	/** Validation engine */
	@Autowired
	private ValidatorEngine validator;
	
	@PostMapping("/password/validate")
	public ResponseEntity<ValidationResponse> validatePassword(@RequestBody (required=false) String password) {
		
		try {
			ValidationResponse response = validator.validateAll(password);
			return ResponseEntity.ok(response);
		}
		catch (Exception e) {
			
			log.error(e.getMessage());
			ValidationResponse response = new ValidationResponse(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
}
