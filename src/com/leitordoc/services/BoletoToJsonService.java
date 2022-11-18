package com.leitordoc.services;

// Importing java input/output classes
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import com.aspose.pdf.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.google.gson.Gson;
import com.leitordoc.models.BoletoBancario;
import com.leitordoc.utils.Boleto2Utils;
import com.leitordoc.utils.Boleto1Utils;

public class BoletoToJsonService {
	private String readExtractionString;
	private String tableExtractionString;
	
	public static String convert (String filePath) {	
		BoletoToJsonService service = new BoletoToJsonService();
		try {
			service.setReadExtractionMethod(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		service.setTableExtractionMethod(filePath);
		String readEString = service.getReadExtractionString();
//		System.out.println(readEString);
		String fichaCompensacao1 = Boleto1Utils.getFichaCompensacao(readEString);
//		System.out.println(fichaCompensacao1);
		String tableEString = service.getTableExtractionString();
		//Primeiro item docBeneficiario, segundo docPagador
		String[] documentos = Boleto1Utils.getDocs(readEString);
		if (documentos[0] == null || documentos[1] == null) {
			documentos = Boleto2Utils.getDocs(tableEString);
		}
		String linhaDigitavel = Boleto1Utils.getLinhaDigitavel(readEString);
		String codBanco = Boleto1Utils.getCodBanco(readEString);
		// Para transformar todos os valores numa string de apenas números StringUtils.toNumbersOnly(string);
		String valor = Boleto1Utils.getValor(fichaCompensacao1);
		// A primeira data é "mais cedo", portanto é a data de emissão, a segunda data, a de vencimento
		Date[] datas = Boleto1Utils.getDatas(fichaCompensacao1);
		String localPagamento = Boleto1Utils.getLocalPagamento(fichaCompensacao1);
		String nomBeneficiario = Boleto1Utils.getNomBeneficiario(fichaCompensacao1);
		String codigoBeneficiario = Boleto1Utils.getCodigoBeneficiario(fichaCompensacao1);
		String nomePagador = Boleto1Utils.getNomePagador(fichaCompensacao1);
		String multa = Boleto1Utils.getMulta(fichaCompensacao1);		
		String nossoNumero = Boleto1Utils.getNossoNumero(fichaCompensacao1);
		String carteira = Boleto1Utils.getCarteira(fichaCompensacao1);
		String mora = Boleto1Utils.getMora(fichaCompensacao1);
		String aceite = Boleto1Utils.getAceite(fichaCompensacao1);
		String instrucoes = Boleto1Utils.getInstrucoes(fichaCompensacao1);
		String moeda = Boleto1Utils.getMoeda(fichaCompensacao1);
		BoletoBancario bb = new BoletoBancario(1, "descricao", filePath, "tipo", 
		nomBeneficiario, documentos[0], codigoBeneficiario, moeda, codBanco, 
		nomePagador, documentos[1], linhaDigitavel, datas[0], datas[1], 
		valor, nossoNumero, localPagamento, multa, carteira, mora, aceite, instrucoes);
		
		System.out.println(new Gson().toJson(bb));
		return new Gson().toJson(bb); //Boleto em Json
	}

	

	public void setReadExtractionMethod(String filePath) throws IOException {
		File arquivo = new File(filePath);
		PDDocument documento = PDDocument.load(arquivo);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		pdfStripper.setSortByPosition(true);
		pdfStripper.setLineSeparator("\n");
		String texto = pdfStripper.getText(documento);
		this.readExtractionString = texto;
		documento.close();
	}

	public void setTableExtractionMethod(String filePath) {
//		 String filePath = "C:\\Users\\Usuario\\Desktop\\boleto-caki.pdf";
		    com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(filePath);
		    com.aspose.pdf.TableAbsorber absorber = new com.aspose.pdf.TableAbsorber();
		    String output = null;
		    // Scan pages
		    for (com.aspose.pdf.Page page : pdfDocument.getPages()) {
		        absorber.visit(page);
		        for (com.aspose.pdf.AbsorbedTable table : absorber.getTableList()) {
//		            System.out.println("Table");
		            // Iterate throught list of rows
		            for (com.aspose.pdf.AbsorbedRow row : table.getRowList()) {
		                // Iterate throught list of cell
		                for (com.aspose.pdf.AbsorbedCell cell : row.getCellList()) {
		                    for (com.aspose.pdf.TextFragment fragment : cell.getTextFragments()) {
		                        StringBuilder sb = new StringBuilder();
		                        for (com.aspose.pdf.TextSegment seg : fragment.getSegments())
		                            sb.append(seg.getText());
		                        output += sb.toString() + "|";
		                    }
		                }
		            }
		        }
		    }
		    this.tableExtractionString = output;
		    pdfDocument.close();
	}
	
	public String getReadExtractionString() {
		return readExtractionString;
	}
	public String getTableExtractionString() {
		return tableExtractionString;
	}
}
