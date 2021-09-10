package br.com.itau.password.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/** Response of password validation request */
@Data
@NoArgsConstructor
public class ValidationResponse {

	/** Define if request is valid */
	@JsonProperty(value = "isValid", index = 0)
	private boolean isValid = true;
	
	/** If request is invalid define the reazons */
	@JsonProperty(index = 1)
	@JsonInclude(Include.NON_EMPTY)
	private List<String> reazons = new ArrayList<>();
	
	/** Constructor with a invalid reazon */
	public ValidationResponse(String reazon) {
		addReason(reazon);
	}
	
	/** Add invalid reazon to list */
	public void addReason(String reazon) {
		this.isValid = false;
		this.reazons.add(reazon);
	}
}
