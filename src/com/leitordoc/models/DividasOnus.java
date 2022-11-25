package com.leitordoc.models;

public class DividasOnus {
	private String codigo;
	private String discriminacao;
	private String situacao;
	private String valorPago;
	private String total;
	
	public DividasOnus(String codigo, String discriminacao, String situacao, String valorPago, String total) {
		super();
		this.codigo = codigo;
		this.discriminacao = discriminacao;
		this.situacao = situacao;
		this.valorPago = valorPago;
		this.total = total;
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
}
