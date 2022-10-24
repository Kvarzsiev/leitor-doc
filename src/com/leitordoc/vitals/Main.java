package com.leitordoc.vitals;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import com.leitordoc.controllers.BoletoToJsonController;
import com.leitordoc.services.LeitorPdf;
//import com.leitordoc.database.EnderecoMigration;
import com.leitordoc.views.*;

public class Main {

	public static void main(String[] args) throws ParseException {

		new ListarArquivos();
		/*
		try {
			LeitorPdf lPdf = new LeitorPdf();
//			lPdf.lerArquivo("C:\\Users\\Usuario\\Desktop\\boleto-caki.pdf");
			lPdf.lerArquivo("C:\\Users\\Usuario\\Desktop\\boleto.pdf");
		} 
		catch (IOException ioe) {
			System.out.println(ioe);
		}
		*/
//	}

//		BoletoToJsonController.convert("C:\\Users\\Usuario\\Desktop\\boleto.pdf", "");
//		System.out.println("\n");
//		BoletoToJsonController.convert("C:\\Users\\Usuario\\Desktop\\boleto-caki.pdf", "");
//		System.out.println("\n");
//		BoletoToJsonController.convert("C:\\Users\\Usuario\\Desktop\\boleto-sicredi.pdf", "");
		
	}
}