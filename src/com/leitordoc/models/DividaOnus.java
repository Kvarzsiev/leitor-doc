package com.leitordoc.models;

public class DividaOnus {
	private String codigo;
	private String discriminacao;
	private String situacao;
	private String valorPago;
	
	public DividaOnus(String codigo, String discriminacao, String situacao, String valorPago) {
		super();
		this.codigo = codigo;
		this.discriminacao = discriminacao;
		this.situacao = situacao;
		this.valorPago = valorPago;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDiscriminacao() {
		return discriminacao;
	}
	public void setDiscriminacao(String discriminacao) {
		this.discriminacao = discriminacao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getValorPago() {
		return valorPago;
	}
	public void setValorPago(String valorPago) {
		this.valorPago = valorPago;
	}
}
