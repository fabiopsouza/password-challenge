package br.com.itau.password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Application boot  */
@SpringBootApplication
public class PasswordApplication {
	
	/**
	 * Main method
	 * @param args optional initialization arguements
	 */
	public static void main(String[] args) {
		SpringApplication.run(PasswordApplication.class, args);
	}
}