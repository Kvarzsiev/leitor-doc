package com.leitordoc.models;

import java.util.ArrayList;

public class BensEDireitos {
	private ArrayList<BemDireito> listaBensDireitos;
	private String total;
	
	public BensEDireitos(ArrayList<BemDireito> listaBensDireitos, String total) {
		super();
		this.listaBensDireitos = listaBensDireitos;
		this.total = total;
	}

	public ArrayList<BemDireito> getListaBensDireitos() {
		return listaBensDireitos;
	}

	public void setListaBensDireitos(ArrayList<BemDireito> listaBensDireitos) {
		this.listaBensDireitos = listaBensDireitos;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
}
