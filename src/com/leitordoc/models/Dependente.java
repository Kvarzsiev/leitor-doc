package com.leitordoc.models;

public class Dependente {

	private String codigo;
	private String nome;
	private String dataNasc;
	private String cpf;
	
	public Dependente(String codigo, String nome, String dataNasc, String cpf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
	}
	public String getCodigo() {
		return codigo;
	}	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "Dependente [codigo=" + codigo + ", nome=" + nome + ", dataNasc=" + dataNasc + ", cpf=" + cpf + "]";
	}
}
