package com.leitordoc.services;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.leitordoc.models.BoletoBancario;
import com.leitordoc.utils.DocumentsUtils;

public class LeitorPdf {
	public void lerArquivo(String filePath) throws IOException {
		File arquivo = new File(filePath);
		PDDocument documento = PDDocument.load(arquivo);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		pdfStripper.setSortByPosition(true);
//		System.out.println(pdfStripper.getLineSeparator());
		pdfStripper.setLineSeparator("\n");
//		pdfStripper.setShouldSeparateByBeads(true);
		String texto = pdfStripper.getText(documento);
//		System.out.println(texto);

//		System.out.println(a);

//		System.out.println(mora);
	
		documento.close();
	}
}
