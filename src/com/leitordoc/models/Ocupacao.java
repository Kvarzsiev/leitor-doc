package com.leitordoc.models;

public class Ocupacao {
	private String natureza;
	private String ocupacaoPrincipal;
	private String tipoDeclaracao;
	private String nroReciboUltimaEntrega;
	
	public Ocupacao(String natureza, String ocupacaoPrincipal, String tipoDeclaracao, String nroReciboUltimaEntrega) {
		super();
		this.natureza = natureza;
		this.ocupacaoPrincipal = ocupacaoPrincipal;
		this.tipoDeclaracao = tipoDeclaracao;
		this.nroReciboUltimaEntrega = nroReciboUltimaEntrega;
	}
	public String getNatureza() {
		return natureza;
	}
	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}
	public String getOcupacaoPrincipal() {
		return ocupacaoPrincipal;
	}
	public void setOcupacaoPrincipal(String ocupacaoPrincipal) {
		this.ocupacaoPrincipal = ocupacaoPrincipal;
	}
	public String getTipoDeclaracao() {
		return tipoDeclaracao;
	}
	public void setTipoDeclaracao(String tipoDeclaracao) {
		this.tipoDeclaracao = tipoDeclaracao;
	}
	public String getNroReciboUltimaEntrega() {
		return nroReciboUltimaEntrega;
	}
	public void setNroReciboUltimaEntrega(String nroReciboUltimaEntrega) {
		this.nroReciboUltimaEntrega = nroReciboUltimaEntrega;
	}
}
