package com.leitordoc.validators;

import com.leitordoc.models.BoletoBancario;

public class BoletoBancarioValidator extends Validator {
	private BoletoBancario boleto;
	
	public BoletoBancarioValidator() {
		super();
	}
	public BoletoBancarioValidator(BoletoBancario boleto) {
		super();
		this.boleto = boleto;
		this.validate(boleto);
	}
	
	public BoletoBancario getBoleto() {
		return boleto;
	}
	public void setBoleto(BoletoBancario boleto) {
		this.boleto = boleto;
	}
	public void validate(BoletoBancario boleto) {
		System.out.println("a: " + boleto.getNomBeneficiario());
		System.out.println("b: " + boleto.getDocBeneficiario());
		System.out.println("d: " + boleto.getNomPagador());
		System.out.println("e: " + boleto.getDocPagador());
		System.out.println("f: " + boleto.getLinhaDigitavel());
		this.validate(boleto.getNomBeneficiario());
		this.validate(boleto.getDocBeneficiario());
		this.validate(boleto.getNomPagador());
		this.validate(boleto.getDocPagador());
		this.validate(boleto.getLinhaDigitavel());
	}
}
