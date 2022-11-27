package com.leitordoc.models;

import java.util.ArrayList;

public class DependentesInf {
	private ArrayList<Dependente> dependentes;
	private String deducaoTotal;
	
	
	public DependentesInf(ArrayList<Dependente> dependentes, String deducaoTotal) {
		super();
		this.dependentes = dependentes;
		this.deducaoTotal = deducaoTotal;
	}
	public ArrayList<Dependente> getDependentes() {
		return dependentes;
	}
	public void setDependentes(ArrayList<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	public String getDeducaoTotal() {
		return deducaoTotal;
	}
	public void setDeducaoTotal(String deducaoTotal) {
		this.deducaoTotal = deducaoTotal;
	} 
}
