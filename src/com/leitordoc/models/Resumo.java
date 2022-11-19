package com.leitordoc.models;

public class Resumo {
	private RendimentoTributavel rendimentoTributavel;
	private ImpostoPago impostoPago;
	private String impostoRestituir;
	private String saldoAPagar;
	private Parcelamento parcelamento;
	private InformacaoBancaria informacaoBancaria;
	private EvolucaoPatrimonial evolucaoPatrimonial;
	private OutrasInformacoes outrasInformacoes;
	
	public Resumo(RendimentoTributavel rendimentoTributavel, ImpostoPago impostoPago, String impostoRestituir,
			String saldoAPagar, Parcelamento parcelamento, InformacaoBancaria informacaoBancaria,
			EvolucaoPatrimonial evolucaoPatrimonial, OutrasInformacoes outrasInformacoes) {
		super();
		this.rendimentoTributavel = rendimentoTributavel;
		this.impostoPago = impostoPago;
		this.impostoRestituir = impostoRestituir;
		this.saldoAPagar = saldoAPagar;
		this.parcelamento = parcelamento;
		this.informacaoBancaria = informacaoBancaria;
		this.evolucaoPatrimonial = evolucaoPatrimonial;
		this.outrasInformacoes = outrasInformacoes;
	}
	public RendimentoTributavel getRendimentoTributavel() {
		return rendimentoTributavel;
	}
	public void setRendimentoTributavel(RendimentoTributavel rendimentoTributavel) {
		this.rendimentoTributavel = rendimentoTributavel;
	}
	public ImpostoPago getImpostoPago() {
		return impostoPago;
	}
	public void setImpostoPago(ImpostoPago impostoPago) {
		this.impostoPago = impostoPago;
	}
	public String getImpostoRestituir() {
		return impostoRestituir;
	}
	public void setImpostoRestituir(String impostoRestituir) {
		this.impostoRestituir = impostoRestituir;
	}
	public String getSaldoAPagar() {
		return saldoAPagar;
	}
	public void setSaldoAPagar(String saldoAPagar) {
		this.saldoAPagar = saldoAPagar;
	}
	public Parcelamento getParcelamento() {
		return parcelamento;
	}
	public void setParcelamento(Parcelamento parcelamento) {
		this.parcelamento = parcelamento;
	}
	public InformacaoBancaria getInformacaoBancaria() {
		return informacaoBancaria;
	}
	public void setInformacaoBancaria(InformacaoBancaria informacaoBancaria) {
		this.informacaoBancaria = informacaoBancaria;
	}
	public EvolucaoPatrimonial getEvolucaoPatrimonial() {
		return evolucaoPatrimonial;
	}
	public void setEvolucaoPatrimonial(EvolucaoPatrimonial evolucaoPatrimonial) {
		this.evolucaoPatrimonial = evolucaoPatrimonial;
	}
	public OutrasInformacoes getOutrasInformacoes() {
		return outrasInformacoes;
	}
	public void setOutrasInformacoes(OutrasInformacoes outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}
}
