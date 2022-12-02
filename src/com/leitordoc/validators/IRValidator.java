package com.leitordoc.validators;

import com.leitordoc.models.DeclaracaoIR;

public class IRValidator extends Validator {
	
	private DeclaracaoIR dir;
	
	public IRValidator() {
		super();
	}
	public IRValidator(DeclaracaoIR dir) {
		super();
		this.dir = dir;
		this.validate(dir);
	}
	public DeclaracaoIR getDir() {
		return dir;
	}
	public void setDir(DeclaracaoIR dir) {
		this.dir = dir;
	}
	public void validate(DeclaracaoIR dir) {
		
	}
}
