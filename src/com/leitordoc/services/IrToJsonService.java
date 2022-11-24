package com.leitordoc.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import com.aspose.pdf.*;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.google.gson.Gson;
import com.leitordoc.models.BoletoBancario;
import com.leitordoc.models.DeclaracaoIR;
import com.leitordoc.utils.Boleto1Utils;
import com.leitordoc.utils.IR1Utils;

public class IrToJsonService {
	private ArrayList<String> stringfiedPages;
	
	
	public IrToJsonService() {
		super();
		this.stringfiedPages = new ArrayList<String>();
	}

	public static DeclaracaoIR convert (String filePath) {	
		IrToJsonService service = new IrToJsonService();
		try {
			service.setReadExtractionMethod(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> pages = service.getStringfiedPages();
		
		String nome = IR1Utils.getNome(pages.get(0));
		String cpf = IR1Utils.getCPF(pages.get(0));
		String exercicio = IR1Utils.getExercicio(pages.get(0));
		System.out.println(exercicio);
//		System.out.println(pages.get(0));
//
//		String fichaCompensacao1 = Boleto1Utils.getFichaCompensacao(readEString);
//
//		//Primeiro item docBeneficiario, segundo docPagador
//		String[] documentos = Boleto1Utils.getDocs(readEString);
//
//		String linhaDigitavel = Boleto1Utils.getLinhaDigitavel(readEString);
//		String codBanco = Boleto1Utils.getCodBanco(readEString);
//		// Para transformar todos os valores numa string de apenas números StringUtils.toNumbersOnly(string);
//		String valor = Boleto1Utils.getValor(fichaCompensacao1);
//		// A primeira data é "mais cedo", portanto é a data de emissão, a segunda data, a de vencimento
//		Date[] datas = Boleto1Utils.getDatas(fichaCompensacao1);
//		String localPagamento = Boleto1Utils.getLocalPagamento(fichaCompensacao1);
//		String nomBeneficiario = Boleto1Utils.getNomBeneficiario(fichaCompensacao1);
//		String codigoBeneficiario = Boleto1Utils.getCodigoBeneficiario(fichaCompensacao1);
//		String nomePagador = Boleto1Utils.getNomePagador(fichaCompensacao1);
//		String multa = Boleto1Utils.getMulta(fichaCompensacao1);		
//		String nossoNumero = Boleto1Utils.getNossoNumero(fichaCompensacao1);
//		String carteira = Boleto1Utils.getCarteira(fichaCompensacao1);
//		String mora = Boleto1Utils.getMora(fichaCompensacao1);
//		String aceite = Boleto1Utils.getAceite(fichaCompensacao1);
//		String instrucoes = Boleto1Utils.getInstrucoes(fichaCompensacao1);
//		String moeda = Boleto1Utils.getMoeda(fichaCompensacao1);
		DeclaracaoIR dir = new DeclaracaoIR();
//		
//		System.out.println(new Gson().toJson(dir));
		return dir; //Boleto em Json
	}

	public void setReadExtractionMethod(String filePath) throws IOException {
		File arquivo = new File(filePath);
		PDDocument documento = PDDocument.load(arquivo);
		Splitter splitter = new Splitter();
		ArrayList<PDDocument> pages = (ArrayList<PDDocument>) splitter.split(documento);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		pdfStripper.setSortByPosition(true);
		pdfStripper.setLineSeparator("\n");
		for (PDDocument page : pages) {
			String texto = pdfStripper.getText(page);
			this.addStringfiedPage(texto);
		}
		documento.close();
	}
	
	public ArrayList<String> getStringfiedPages() {
		return stringfiedPages;
	}

	public void addStringfiedPage(String stringfiedPage) {
		this.stringfiedPages.add(stringfiedPage);
	}

}
