package com.leitordoc.models;

public class RendimentosTributacaoExclusiva {
	private String razao;
	private String valor;
	private String cnpjFontePagadora;
	private String fontePagadora;
	private String total;
	
	public RendimentosTributacaoExclusiva(String razao, String valor, String cnpjFontePagadora, String fontePagadora,
			String total) {
		super();
		this.razao = razao;
		this.valor = valor;
		this.cnpjFontePagadora = cnpjFontePagadora;
		this.fontePagadora = fontePagadora;
		this.total = total;
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
	public String getCnpjFontePagadora() {
		return cnpjFontePagadora;
	}
	public void setCnpjFontePagadora(String cnpjFontePagadora) {
		this.cnpjFontePagadora = cnpjFontePagadora;
	}
	public String getFontePagadora() {
		return fontePagadora;
	}
	public void setFontePagadora(String fontePagadora) {
		this.fontePagadora = fontePagadora;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
}
