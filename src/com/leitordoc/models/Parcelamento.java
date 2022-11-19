package com.leitordoc.models;

public class Parcelamento {
	private String valorQuota;
	private String numeroQuota;
	
	
	public Parcelamento(String valorQuota, String numeroQuota) {
		super();
		this.valorQuota = valorQuota;
		this.numeroQuota = numeroQuota;
	}
	public String getValorQuota() {
		return valorQuota;
	}
	public void setValorQuota(String valorQuota) {
		this.valorQuota = valorQuota;
	}
	public String getNumeroQuota() {
		return numeroQuota;
	}
	public void setNumeroQuota(String numeroQuota) {
		this.numeroQuota = numeroQuota;
	}
}
