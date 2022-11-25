package com.leitordoc.models;

import java.util.ArrayList;

public class Resumo {
	private ArrayList<RendimentoTributavel> rendimentosTributaveis;
	private ImpostoPago impostoPago;
	private String impostoRestituir;
	private String saldoAPagar;
	private Parcelamento parcelamento;
	private InformacaoBancaria informacaoBancaria;
	private EvolucaoPatrimonial evolucaoPatrimonial;
	private OutrasInformacoes outrasInformacoes;
	
	public Resumo(ArrayList<RendimentoTributavel> rendimentosTributaveis, ImpostoPago impostoPago, String impostoRestituir,
			String saldoAPagar, Parcelamento parcelamento, InformacaoBancaria informacaoBancaria,
			EvolucaoPatrimonial evolucaoPatrimonial, OutrasInformacoes outrasInformacoes) {
		super();
		this.rendimentosTributaveis = rendimentosTributaveis;
		this.impostoPago = impostoPago;
		this.impostoRestituir = impostoRestituir;
		this.saldoAPagar = saldoAPagar;
		this.parcelamento = parcelamento;
		this.informacaoBancaria = informacaoBancaria;
		this.evolucaoPatrimonial = evolucaoPatrimonial;
		this.outrasInformacoes = outrasInformacoes;
	}
	public ArrayList<RendimentoTributavel> getRendimentoTributavel() {
		return rendimentosTributaveis;
	}
	public void setRendimentoTributavel(ArrayList<RendimentoTributavel> rendimentosTributaveis) {
		this.rendimentosTributaveis = rendimentosTributaveis;
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
