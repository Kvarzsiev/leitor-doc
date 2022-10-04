package com.leitordoc.vitals;


import java.text.ParseException;
import com.leitordoc.database.EnderecoMigration;
//import com.leitordoc.views.*;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		EnderecoMigration em = new EnderecoMigration();
		em.DownQuery();
		
	}

}