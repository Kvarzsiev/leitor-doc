package com.leitordoc.validators;

import java.util.Date;

public class BoletoBancarioValidator {
	private Boolean boletoValido;
	private Boolean nomBeneficiario;
	private Boolean docBeneficiario;
	private Boolean codBeneficiario;
	private Boolean codBanco;
	private Boolean nomPagador;
	private Boolean docPagador;
	private Boolean linhaDigitavel;
	private Boolean emissao;
	private Boolean vencimento;
	private Boolean valor;
	private Boolean nossoNumero;
	private Boolean localPagamento;
	private Boolean carteira;
	private Boolean aceite;
	private Boolean instrucoes;
	
	public BoletoBancarioValidator(Boolean nomBeneficiario, Boolean docBeneficiario,
			Boolean codBeneficiario, Boolean codBanco, Boolean nomPagador, Boolean docPagador, Boolean linhaDigitavel,
			Boolean emissao, Boolean vencimento, Boolean valor, Boolean nossoNumero, Boolean localPagamento,
			Boolean carteira, Boolean aceite, Boolean instrucoes) {
		super();
		this.nomBeneficiario = nomBeneficiario;
		this.docBeneficiario = docBeneficiario;
		this.codBeneficiario = codBeneficiario;
		this.codBanco = codBanco;
		this.nomPagador = nomPagador;
		this.docPagador = docPagador;
		this.linhaDigitavel = linhaDigitavel;
		this.emissao = emissao;
		this.vencimento = vencimento;
		this.valor = valor;
		this.nossoNumero = nossoNumero;
		this.localPagamento = localPagamento;
		this.carteira = carteira;
		this.aceite = aceite;
		this.instrucoes = instrucoes;
		this.boletoValido = true;
	}

	public Boolean getBoletoValido() {
		return boletoValido;
	}

	public void setBoletoValido(Boolean boletoValido) {
		this.boletoValido = boletoValido;
	}

	public Boolean getNomBeneficiario() {
		return nomBeneficiario;
	}

	public void setNomBeneficiario(Boolean nomBeneficiario) {
		this.nomBeneficiario = nomBeneficiario;
	}

	public Boolean getDocBeneficiario() {
		return docBeneficiario;
	}

	public void setDocBeneficiario(Boolean docBeneficiario) {
		this.docBeneficiario = docBeneficiario;
	}

	public Boolean getCodBeneficiario() {
		return codBeneficiario;
	}

	public void setCodBeneficiario(Boolean codBeneficiario) {
		this.codBeneficiario = codBeneficiario;
	}

	public Boolean getCodBanco() {
		return codBanco;
	}

	public void setCodBanco(Boolean codBanco) {
		this.codBanco = codBanco;
	}

	public Boolean getNomPagador() {
		return nomPagador;
	}

	public void setNomPagador(Boolean nomPagador) {
		this.nomPagador = nomPagador;
	}

	public Boolean getDocPagador() {
		return docPagador;
	}

	public void setDocPagador(Boolean docPagador) {
		this.docPagador = docPagador;
	}

	public Boolean getLinhaDigitavel() {
		return linhaDigitavel;
	}

	public void setLinhaDigitavel(Boolean linhaDigitavel) {
		this.linhaDigitavel = linhaDigitavel;
	}

	public Boolean getEmissao() {
		return emissao;
	}

	public void setEmissao(Boolean emissao) {
		this.emissao = emissao;
	}

	public Boolean getVencimento() {
		return vencimento;
	}

	public void setVencimento(Boolean vencimento) {
		this.vencimento = vencimento;
	}

	public Boolean getValor() {
		return valor;
	}

	public void setValor(Boolean valor) {
		this.valor = valor;
	}

	public Boolean getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(Boolean nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public Boolean getLocalPagamento() {
		return localPagamento;
	}

	public void setLocalPagamento(Boolean localPagamento) {
		this.localPagamento = localPagamento;
	}

	public Boolean getCarteira() {
		return carteira;
	}

	public void setCarteira(Boolean carteira) {
		this.carteira = carteira;
	}

	public Boolean getAceite() {
		return aceite;
	}

	public void setAceite(Boolean aceite) {
		this.aceite = aceite;
	}

	public Boolean getInstrucoes() {
		return instrucoes;
	}

	public void setInstrucoes(Boolean instrucoes) {
		this.instrucoes = instrucoes;
	}
	
}
