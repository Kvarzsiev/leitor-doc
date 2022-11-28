package com.leitordoc.models;

import java.util.ArrayList;

public class DividasOnus {
	private ArrayList<DividaOnus> listaDividas;
	private String total;
	
	public DividasOnus(ArrayList<DividaOnus> listaDividas, String total) {
		super();
		this.listaDividas = listaDividas;
		this.total = total;
	}
	public ArrayList<DividaOnus> getListaDividas() {
		return listaDividas;
	}
	public void setListaDividas(ArrayList<DividaOnus> listaDividas) {
		this.listaDividas = listaDividas;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	
}
