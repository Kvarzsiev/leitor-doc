package com.leitordoc.services;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import com.leitordoc.utils.DocumentsUtils;

public class LeitorPdf {
	public void lerArquivo(String filePath) throws IOException {
		File arquivo = new File(filePath);
		PDDocument documento = PDDocument.load(arquivo);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String texto = pdfStripper.getText(documento);
		//Primeiro item docBeneficiario, segundo docPagador
		String[] documentos = DocumentsUtils.getDocs(texto);
		String linhaDigitavel = DocumentsUtils.getLinhaDigitavel(texto);
		String codBanco = DocumentsUtils.getCodBanco(texto);
		// Para transformar todos os valores numa string de apenas números StringUtils.toNumbersOnly(string);
		String valor = DocumentsUtils.getValor(texto);
		// A primeira data é "mais cedo", portanto é a data de emissão, a segunda data, a de vencimento
		Date[] datas = DocumentsUtils.getDatas(texto);


	}
}
