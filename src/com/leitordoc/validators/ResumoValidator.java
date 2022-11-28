package com.leitordoc.validators;

import com.leitordoc.models.InformacaoBancaria;
import com.leitordoc.models.Parcelamento;
import com.leitordoc.models.Resumo;

public class ResumoValidator extends Validator {
	private Resumo resumo;
	
	// Constructors
	public ResumoValidator() {
		super();
	}
	public ResumoValidator(Resumo resumo) {
		super();
		this.resumo = resumo;
		this.validate(resumo);
	}
	// Methods
	public Resumo getResumo() {
		return resumo;
	}
	public void setResumo(Resumo resumo) {
		this.resumo = resumo;
	}
	
	public void validate(Resumo resumo) {
		this.validate(resumo.getRendimentoTributavel());
		this.validate(resumo.getimpostosPagos());
		this.validate(resumo.getImpostoRestituir());
		this.validate(resumo.getSaldoAPagar());
		this.validateParcelamento(resumo.getParcelamento());
		this.validate(resumo.getEvolucaoPatrimonial());
	}
	
	private void validateParcelamento(Parcelamento parcelamento) {
		this.validate(parcelamento.getValorQuota());
		this.validate(parcelamento.getNumeroQuota());
	}
	
}
