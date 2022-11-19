package com.leitordoc.models;

public class ImpostoPagoRetido {
	private String razao;
	private String valor;
	
	public ImpostoPagoRetido(String razao, String valor) {
		super();
		this.razao = razao;
		this.valor = valor;
	}
	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}
