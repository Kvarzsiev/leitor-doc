package com.leitordoc.validators;

import com.leitordoc.models.DeclaracaoIR;

public class IRValidator extends Validator {
	
	private DeclaracaoIR dir;
	private Boolean valido = true;
	
	public IRValidator() {
		super();
	}
	public IRValidator(DeclaracaoIR dir, Boolean valido) {
		super();
		this.dir = dir;
		this.valido = valido;
	}
	public DeclaracaoIR getDir() {
		return dir;
	}
	public void setDir(DeclaracaoIR dir) {
		this.dir = dir;
	}
	public Boolean getValido() {
		return valido;
	}
	public void setValido(Boolean valido) {
		this.valido = valido;
	}
	
}
