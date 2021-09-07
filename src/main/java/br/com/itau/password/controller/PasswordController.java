package br.com.itau.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.itau.password.validator.ValidatorEngine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PasswordController {

	@Autowired
	private ValidatorEngine validator;
	
	@PostMapping("/password/validate")
	public ResponseEntity<Boolean> validatePassword(@RequestBody (required=false) String password) {
		
		try {
			
			validator.validateAll(password);
			return ResponseEntity.ok(true);
		}
		catch (IllegalArgumentException e) {
			
			log.error(e.getMessage());
			return ResponseEntity.ok(false);
		}
	}
}
