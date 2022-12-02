package com.leitordoc.models;

import java.util.ArrayList;

public class DeclaracaoIR {
	private String nome;
	private String cpf;
	private String exercicio;
	private String anoCalendario;
	private Endereco endereco;
	private Ocupacao ocupacao;
	private DependentesInf dependentes; 
	private ArrayList<Completa> rendTributRecebPessJur;
	private String rendimentosJPDependentes;
	private String rendimentosPFExteriorTitular;
	private String rendimentosPFExteriorDependente;
	private ArrayList<Rendimentos> rendimentoNaoTributavelIsento;
	private ArrayList<Rendimentos> rendimentoTributacaoExclusiva;
	private ArrayList<ImpostoPagoRetido> impostoPagoRetido;
	private BensEDireitos bensEDireitos;
	private DividasOnus dividasOnus;
	private Resumo resumo;
	
	public DeclaracaoIR(String nome, String cpf, String exercicio, String anoCalendario, Endereco endereco,
			Ocupacao ocupacao, DependentesInf dependentes, ArrayList<Completa> rendTributRecebPessJur,
			String rendimentosJPDependentes, String rendimentosPFExteriorTitular,
			String rendimentosPFExteriorDependente, ArrayList<Rendimentos> rendimentoNaoTributavelIsento,
			ArrayList<Rendimentos> rendimentoTributacaoExclusiva, ArrayList<ImpostoPagoRetido> impostoPagoRetido,
			BensEDireitos bensEDireitos, DividasOnus dividasOnus, Resumo resumo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.exercicio = exercicio;
		this.anoCalendario = anoCalendario;
		this.endereco = endereco;
		this.ocupacao = ocupacao;
		this.dependentes = dependentes;
		this.rendTributRecebPessJur = rendTributRecebPessJur;
		this.rendimentosJPDependentes = rendimentosJPDependentes;
		this.rendimentosPFExteriorTitular = rendimentosPFExteriorTitular;
		this.rendimentosPFExteriorDependente = rendimentosPFExteriorDependente;
		this.rendimentoNaoTributavelIsento = rendimentoNaoTributavelIsento;
		this.rendimentoTributacaoExclusiva = rendimentoTributacaoExclusiva;
		this.impostoPagoRetido = impostoPagoRetido;
		this.bensEDireitos = bensEDireitos;
		this.dividasOnus = dividasOnus;
		this.resumo = resumo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getExercicio() {
		return exercicio;
	}
	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}
	public String getAnoCalendario() {
		return anoCalendario;
	}
	public void setAnoCalendario(String anoCalendario) {
		this.anoCalendario = anoCalendario;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Ocupacao getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(Ocupacao ocupacao) {
		this.ocupacao = ocupacao;
	}
	public DependentesInf getDependentes() {
		return dependentes;
	}
	public void setDependentes(DependentesInf dependentes) {
		this.dependentes = dependentes;
	}
	public ArrayList<Completa> getRendTributRecebPessJur() {
		return rendTributRecebPessJur;
	}
	public void setRendTributRecebPessJur(ArrayList<Completa> rendTributRecebPessJur) {
		this.rendTributRecebPessJur = rendTributRecebPessJur;
	}
	public String getRendimentosJPDependentes() {
		return rendimentosJPDependentes;
	}
	public void setRendimentosJPDependentes(String rendimentosJPDependentes) {
		this.rendimentosJPDependentes = rendimentosJPDependentes;
	}
	public String getRendimentosPFExteriorTitular() {
		return rendimentosPFExteriorTitular;
	}
	public void setRendimentosPFExteriorTitular(String rendimentosPFExteriorTitular) {
		this.rendimentosPFExteriorTitular = rendimentosPFExteriorTitular;
	}
	public String getRendimentosPFExteriorDependente() {
		return rendimentosPFExteriorDependente;
	}
	public void setRendimentosPFExteriorDependente(String rendimentosPFExteriorDependente) {
		this.rendimentosPFExteriorDependente = rendimentosPFExteriorDependente;
	}
	public ArrayList<Rendimentos> getRendimentoNaoTributavelIsento() {
		return rendimentoNaoTributavelIsento;
	}
	public void setRendimentoNaoTributavelIsento(ArrayList<Rendimentos> rendimentoNaoTributavelIsento) {
		this.rendimentoNaoTributavelIsento = rendimentoNaoTributavelIsento;
	}
	public ArrayList<Rendimentos> getRendimentoTributacaoExclusiva() {
		return rendimentoTributacaoExclusiva;
	}
	public void setRendimentoTributacaoExclusiva(ArrayList<Rendimentos> rendimentoTributacaoExclusiva) {
		this.rendimentoTributacaoExclusiva = rendimentoTributacaoExclusiva;
	}
	public ArrayList<ImpostoPagoRetido> getImpostoPagoRetido() {
		return impostoPagoRetido;
	}
	public void setImpostoPagoRetido(ArrayList<ImpostoPagoRetido> impostoPagoRetido) {
		this.impostoPagoRetido = impostoPagoRetido;
	}
	public BensEDireitos getBensEDireitos() {
		return bensEDireitos;
	}
	public void setBensEDireitos(BensEDireitos bensEDireitos) {
		this.bensEDireitos = bensEDireitos;
	}
	public DividasOnus getDividasOnus() {
		return dividasOnus;
	}
	public void setDividasOnus(DividasOnus dividasOnus) {
		this.dividasOnus = dividasOnus;
	}
	public Resumo getResumo() {
		return resumo;
	}
	public void setResumo(Resumo resumo) {
		this.resumo = resumo;
	}
}
