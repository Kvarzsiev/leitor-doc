package com.leitordoc.models;

import java.sql.Date;

public class Pessoa {
	private int id;
	private String nome;
	private Endereco endereco;
	private String cpf;
	private String cnpj;
	private Date criadoEm;
	private Date editadoEm;
	
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", cnpj=" + cnpj
				+ ", criadoEm=" + criadoEm + ", editadoEm=" + editadoEm + "]";
	}
	public Pessoa(int id, String nome, Endereco endereco, String cpf, String cnpj, Date criadoEm, Date editadoEm) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.criadoEm = criadoEm;
		this.editadoEm = editadoEm;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Date getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}
	public Date getEditadoEm() {
		return editadoEm;
	}
	public void setEditadoEm(Date editadoEm) {
		this.editadoEm = editadoEm;
	}
}
