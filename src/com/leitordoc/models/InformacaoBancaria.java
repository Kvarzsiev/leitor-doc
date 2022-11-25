package com.leitordoc.models;

public class InformacaoBancaria {
	private String tipoDaConta;
	private String banco;
	private String agencia;
	private String conta;
	
	public InformacaoBancaria(String tipoDaConta, String banco, String agencia, String conta) {
		super();
		this.tipoDaConta = tipoDaConta;
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
	}
	public String getTipoDaConta() {
		return tipoDaConta;
	}
	public void setTipoDaConta(String tipoDaConta) {
		this.tipoDaConta = tipoDaConta;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	
}
