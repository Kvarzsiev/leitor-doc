package com.leitordoc.services;

import java.io.File;
import java.io.IOException;
import java.util.Date;

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
//		System.out.println("res" + readEString);
		String fichaCompensacao1 = Boleto1Utils.getFichaCompensacao(readEString);
		String tableEString = service.getTableExtractionString();
		//Primeiro item docBeneficiario, segundo docPagador
		String[] documentos = Boleto1Utils.getDocs(readEString);
//		if (documentos[0] == null || documentos[1] == null) {
//			documentos = Boleto2Utils.getDocs(tableEString);
//		}
//		String linhaDigitavel = Boleto1Utils.getLinhaDigitavel(readEString);
		
//		String codBanco = Boleto1Utils.getCodBanco(fichaCompensacao);
//		// Para transformar todos os valores numa string de apenas números StringUtils.toNumbersOnly(string);
//		String valor = Boleto1Utils.getValor(fichaCompensacao);
//		// A primeira data é "mais cedo", portanto é a data de emissão, a segunda data, a de vencimento
//		Date[] datas = Boleto1Utils.getDatas(fichaCompensacao);
//		String localPagamento = Boleto1Utils.getLocalPagamento(fichaCompensacao);
//		String nomBeneficiario = Boleto1Utils.getNomBeneficiario(fichaCompensacao);
//		String codigoBeneficiario = Boleto1Utils.getCodigoBeneficiario(fichaCompensacao);
//		String nomePagador = Boleto1Utils.getNomePagador(fichaCompensacao);
//		String multa = Boleto1Utils.getMulta(fichaCompensacao);		
//		String nossoNumero = Boleto1Utils.getNossoNumero(fichaCompensacao);
//		String carteira = Boleto1Utils.getCarteira(fichaCompensacao);
//		String mora = Boleto1Utils.getMora(fichaCompensacao);
//		String aceite = Boleto1Utils.getAceite(fichaCompensacao1);
		String instrucoes = Boleto1Utils.getInstrucoes(fichaCompensacao1);
		System.out.println("instrucoes: " + instrucoes);
//		
//		BoletoBancario bb = new BoletoBancario(1, "descricao", 
//		"C:\\Users\\Usuario\\Desktop\\boleto.pdf", "tipo", 
//		nomBeneficiario, documentos[0], codigoBeneficiario, codBanco, 
//		nomePagador, documentos[1], linhaDigitavel, datas[0], datas[1], 
//		valor, nossoNumero, localPagamento, multa, carteira, mora);
//		
//		System.out.println(new Gson().toJson(bb));
//		return new Gson().toJson(bb); //Boleto em Json
			return "";
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
//		    System.out.println(output);
		    this.tableExtractionString = output;
	}
	
	public String getReadExtractionString() {
		return readExtractionString;
	}
	public String getTableExtractionString() {
		return tableExtractionString;
	}
}
