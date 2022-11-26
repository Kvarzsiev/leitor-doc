package com.leitordoc.models;

import java.util.ArrayList;

public class Resumo {
	private ArrayList<DescricaoValor> rendimentosTributaveis;
	private ArrayList<DescricaoValor> impostosPagos;
	private String impostoRestituir;
	private String saldoAPagar;
	private Parcelamento parcelamento;
	private InformacaoBancaria informacaoBancaria;
	private ArrayList<DescricaoValor> evolucaoPatrimonial;
	private ArrayList<DescricaoValor> outrasInformacoes;
	
	public Resumo(ArrayList<DescricaoValor> rendimentosTributaveis, ArrayList<DescricaoValor> impostosPagos, String impostoRestituir,
			String saldoAPagar, Parcelamento parcelamento, InformacaoBancaria informacaoBancaria,
			ArrayList<DescricaoValor> evolucaoPatrimonial, ArrayList<DescricaoValor> outrasInformacoes) {
		super();
		this.rendimentosTributaveis = rendimentosTributaveis;
		this.impostosPagos = impostosPagos;
		this.impostoRestituir = impostoRestituir;
		this.saldoAPagar = saldoAPagar;
		this.parcelamento = parcelamento;
		this.informacaoBancaria = informacaoBancaria;
		this.evolucaoPatrimonial = evolucaoPatrimonial;
		this.outrasInformacoes = outrasInformacoes;
	}
	public ArrayList<DescricaoValor> getRendimentoTributavel() {
		return rendimentosTributaveis;
	}
	public void setRendimentoTributavel(ArrayList<DescricaoValor> rendimentosTributaveis) {
		this.rendimentosTributaveis = rendimentosTributaveis;
	}
	public ArrayList<DescricaoValor> getimpostosPagos() {
		return impostosPagos;
	}
	public void setimpostosPagos(ArrayList<DescricaoValor> impostosPagos) {
		this.impostosPagos = impostosPagos;
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
	public ArrayList<DescricaoValor> getEvolucaoPatrimonial() {
		return evolucaoPatrimonial;
	}
	public void setEvolucaoPatrimonial(ArrayList<DescricaoValor> evolucaoPatrimonial) {
		this.evolucaoPatrimonial = evolucaoPatrimonial;
	}
	public ArrayList<DescricaoValor> getOutrasInformacoes() {
		return outrasInformacoes;
	}
	public void setOutrasInformacoes(ArrayList<DescricaoValor> outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}
}
