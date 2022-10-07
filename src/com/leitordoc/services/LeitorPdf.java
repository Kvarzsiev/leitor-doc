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
		pdfStripper.setSortByPosition(true);
//		System.out.println(pdfStripper.getLineSeparator());
		pdfStripper.setLineSeparator("\n");
//		pdfStripper.setShouldSeparateByBeads(true);
		String texto = pdfStripper.getText(documento);
//		System.out.println(texto);
		String a = DocumentsUtils.getFichaCompensacao(texto);
//		System.out.println(a);
		String mora = DocumentsUtils.getMora(a);
		System.out.println(mora);
		//Primeiro item docBeneficiario, segundo docPagador
//		String[] documentos = DocumentsUtils.getDocs(texto);
//		String linhaDigitavel = DocumentsUtils.getLinhaDigitavel(texto);
//		String codBanco = DocumentsUtils.getCodBanco(texto);
		// Para transformar todos os valores numa string de apenas números StringUtils.toNumbersOnly(string);
//		String valor = DocumentsUtils.getValor(texto);
		// A primeira data é "mais cedo", portanto é a data de emissão, a segunda data, a de vencimento
//		Date[] datas = DocumentsUtils.getDatas(texto);
//		String localPagamento = DocumentsUtils.getLocalPagamento(a);
//		String nomBeneficiario = DocumentsUtils.getNomBeneficiario(a);
//		String codigoBeneficiario = DocumentsUtils.getCodigoBeneficiario(a);
//		String nomePagador = DocumentsUtils.getNomePagador(a);
//		String multa = DocumentsUtils.getMulta(texto);		
//		String nossoNumero = DocumentsUtils.getNossoNumero(a);
//		String carteira = DocumentsUtils.getCarteira(a);
//
	}
}
