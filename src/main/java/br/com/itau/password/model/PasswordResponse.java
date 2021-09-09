package br.com.itau.password.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PasswordResponse {

	@JsonProperty(value = "isValid", index = 0)
	private boolean isValid = true;
	
	@JsonProperty(index = 1)
	@JsonInclude(Include.NON_EMPTY)
	private List<String> reazons = new ArrayList<>();
	
	public PasswordResponse(String reazon) {
		addReason(reazon);
	}
	
	public void addReason(String reazon) {
		this.isValid = false;
		this.reazons.add(reazon);
	}
}
