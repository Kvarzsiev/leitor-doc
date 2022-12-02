package com.leitordoc.validators;

import com.leitordoc.models.Ocupacao;

public class OcupacaoValidator extends Validator {
	private Ocupacao ocupacao;

	public OcupacaoValidator() {
		super();
	}

	public OcupacaoValidator(Ocupacao ocupacao) {
		super();
		this.ocupacao = ocupacao;
		this.validate(ocupacao);
	}

	public Ocupacao getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Ocupacao ocupacao) {
		this.ocupacao = ocupacao;
	}
	
	public void validate(Ocupacao ocupacao) {
		this.validate(ocupacao.getNatureza());
		this.validate(ocupacao.getTipoDeclaracao());
	}
}
