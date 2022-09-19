package com.leitordoc.models;

import java.util.Calendar;

public class Data {
	//Atributos
	private int dia;
	private int mes;
	private int ano;
	Calendar calendario = Calendar.getInstance();
	//Construtores
	public Data(int dia, int mes, int ano) {
		//Constroi objeto Data com data especificada por parametro
		if(this.validar(dia,mes,ano)) {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
	}	
	public Data() {
		//Constroi objeto Data com data atual
		this.dia = calendario.get(Calendar.DATE);
		this.mes = calendario.get(Calendar.MONTH) + 1;
		this.ano = calendario.get(Calendar.YEAR);
	}
	//Metodos
	public boolean validar(int dia,int mes,int ano) {
		//Verifica se os dados fornecidos são adequados
		if(ano<=0) {
			return false;
		} else if(mes<1 || mes >12) {
			return false;
		} else if(dia<1 || dia>31) {
			return false;
		} else {
			return true;
		}
	}
	public String stringficar() {
		//Transforma data em string no formato dd-mm-aaaa
		return this.dia+"-"+this.mes+"-"+this.ano;
	}
	//Getters e Setters
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Calendar getCalendario() {
		return calendario;
	}
	public void setCalendario(Calendar calendario) {
		this.calendario = calendario;
	}
}
