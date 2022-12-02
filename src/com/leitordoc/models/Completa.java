package com.leitordoc.models;

public class Completa {
	private String fontePagadora;
	private String rendimentosRecebidos;
	private String contrPrevidOficial;
	private String IRRetidoFonte;
	private String _13Salario;
	private String IRSobre13Salario;
	
	public Completa(String fontePagadora, String rendimentosRecebidos, String contrPrevidOficial, String iRRetidoFonte,
			String _13Salario, String iRSobre13Salario) {
		super();
		this.fontePagadora = fontePagadora;
		this.rendimentosRecebidos = rendimentosRecebidos;
		this.contrPrevidOficial = contrPrevidOficial;
		IRRetidoFonte = iRRetidoFonte;
		this._13Salario = _13Salario;
		IRSobre13Salario = iRSobre13Salario;
	}
	public String getFontePagadora() {
		return fontePagadora;
	}
	public void setFontePagadora(String fontePagadora) {
		this.fontePagadora = fontePagadora;
	}
	public String getRendimentosRecebidos() {
		return rendimentosRecebidos;
	}
	public void setRendimentosRecebidos(String rendimentosRecebidos) {
		this.rendimentosRecebidos = rendimentosRecebidos;
	}
	public String getContrPrevidOficial() {
		return contrPrevidOficial;
	}
	public void setContrPrevidOficial(String contrPrevidOficial) {
		this.contrPrevidOficial = contrPrevidOficial;
	}
	public String getIRRetidoFonte() {
		return IRRetidoFonte;
	}
	public void setIRRetidoFonte(String iRRetidoFonte) {
		IRRetidoFonte = iRRetidoFonte;
	}
	public String get_13Salario() {
		return _13Salario;
	}
	public void set_13Salario(String _13Salario) {
		this._13Salario = _13Salario;
	}
	public String getIRSobre13Salario() {
		return IRSobre13Salario;
	}
	public void setIRSobre13Salario(String iRSobre13Salario) {
		IRSobre13Salario = iRSobre13Salario;
	}

	
}
