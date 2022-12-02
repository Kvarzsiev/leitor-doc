package com.leitordoc.validators;

import com.leitordoc.models.Endereco;
import com.leitordoc.models.Resumo;

public class EnderecoValidator extends Validator {
	private Endereco endereco;
	
	public EnderecoValidator(Endereco endereco) {
		super();
		this.endereco = endereco;
		this.validate(endereco);
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void validate(Endereco endereco) {
		this.validate(endereco.getNumero());
		this.validate(endereco.getMunicipio());
		this.validate(endereco.getUf());
		this.validate(endereco.getCep());
		this.validate(endereco.getRua());
	}
}
