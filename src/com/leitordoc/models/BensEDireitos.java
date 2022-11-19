package com.leitordoc.models;

public class BensEDireitos {
	private String codigo;
	private String discriminacao;
	private String situacao;
	private String total;
	
	public BensEDireitos(String codigo, String discriminacao, String situacao, String total) {
		super();
		this.codigo = codigo;
		this.discriminacao = discriminacao;
		this.situacao = situacao;
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
}
