package com.leitordoc.models;

public class BemDireito {
	private String codigo;
	private String discriminacao;
	private String situacao;
	
	public BemDireito(String codigo, String discriminacao, String situacao) {
		super();
		this.codigo = codigo;
		this.discriminacao = discriminacao;
		this.situacao = situacao;
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
}
