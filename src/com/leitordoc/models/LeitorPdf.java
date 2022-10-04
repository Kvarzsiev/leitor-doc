package com.leitordoc.models;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class LeitorPdf {
	public void lerArquivo(String filePath) throws IOException {
		File arquivo = new File(filePath);
		PDDocument documento = PDDocument.load(arquivo);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String texto = pdfStripper.getText(documento);
		System.out.println(texto);
	}
}
