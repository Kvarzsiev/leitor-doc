package com.leitordoc.models;

import java.util.ArrayList;

public class DeclaracaoIR {
	private String nome;
	private String cpf;
	private String exercicio;
	private String anoCalendario;
	private Endereco endereco;
	private Ocupacao ocupacao;
	private ArrayList<String> dependentes; 
	// TODO Simplificada vs completa
	private ArrayList<String> rendimentosJPDependentes;
	private ArrayList<String> rendimentosPFExteriorTitular;
	private ArrayList<String> rendimentosPFExteriorDependente;
	private RendimentoNaoTributavelIsento rendimentoNaoTributavelIsento;
	private RendimentosTributacaoExclusiva rendimentosTributacaoExclusiva;
	private ImpostoPagoRetido impostoPagoRetido;
	private BensEDireitos bensEDireitos;
	private DividasOnus dividasOnus;
	private Resumo resumo;
}
