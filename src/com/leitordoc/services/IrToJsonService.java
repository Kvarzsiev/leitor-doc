package com.leitordoc.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aspose.pdf.*;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.google.gson.Gson;
import com.leitordoc.models.BensEDireitos;
import com.leitordoc.models.BoletoBancario;
import com.leitordoc.models.DeclaracaoIR;
import com.leitordoc.models.DependentesInf;
import com.leitordoc.models.DividasOnus;
import com.leitordoc.models.Endereco;
import com.leitordoc.models.ImpostoPagoRetido;
import com.leitordoc.models.Ocupacao;
import com.leitordoc.models.RendimentoNaoTributavelIsento;
import com.leitordoc.models.Rendimentos;
import com.leitordoc.models.RendimentosTributacaoExclusiva;
import com.leitordoc.models.Resumo;
import com.leitordoc.utils.Boleto1Utils;
import com.leitordoc.utils.DividasOnusUtils;
import com.leitordoc.utils.EnderecoUtils;
import com.leitordoc.utils.IR1Utils;
import com.leitordoc.utils.OcupacaoUtils;
import com.leitordoc.utils.RendimentoNaoTributavelIsentoUtils;
import com.leitordoc.utils.RendimentoTributacaoExclusivaUtils;
import com.leitordoc.utils.ResumoUtils;
import com.leitordoc.validators.IRValidator;
import com.leitordoc.validators.ResumoValidator;

public class IrToJsonService {
	private ArrayList<String> stringfiedPages;
	
	
	public IrToJsonService() {
		super();
		this.stringfiedPages = new ArrayList<String>();
	}

	public static IRValidator convert (String filePath) {	
		IrToJsonService service = new IrToJsonService();
		try {
			// lê o pdf e salva num array de strings (páginas)
			service.setRead(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> sortBypages = service.getStringfiedPages();
		ArrayList<String> pages = service.getStringfiedPages();
		
		String nome = IR1Utils.getNome(sortBypages.get(0));
		String cpf = IR1Utils.getCPF(sortBypages.get(0));
		String exercicio = IR1Utils.getExercicio(sortBypages.get(0));
		String anoCalendario = IR1Utils.getAnoCalendario(sortBypages.get(0));
		Endereco endereco = EnderecoUtils.mountEndereco(sortBypages.get(0));
		Ocupacao ocupacao = OcupacaoUtils.mountOcupacao(sortBypages.get(0));
		DependentesInf dependentesInf = IR1Utils.getDependentesInf(sortBypages.get(0));		
		String rendNaoTributaveisPages = service.getRendimentosNaoTributaveisPages();
		ArrayList<Rendimentos> rendimentoNaoTributavelIsento = RendimentoNaoTributavelIsentoUtils.mountRendimentoNaoTributavelIsento(rendNaoTributaveisPages);
		String rendTributacaoExclusivaPages = service.getRendimentoTributacaoExclusivaPages();
		ArrayList<Rendimentos> rendimentoTributacaoExclusiva = RendimentoTributacaoExclusivaUtils.mountRendimentoTributacaoExclusiva(rendTributacaoExclusivaPages);
//		rendimentosRecebidosPJ
//		ArrayList<String> rendimentosJPDependentes = IR1Utils;
		
//		// TODO Simplificada vs completa
//		private ArrayList<String> rendimentosJPDependentes;
//		private ArrayList<String> rendimentosPFExteriorTitular;
//		private ArrayList<String> rendimentosPFExteriorDependente;

//		private ImpostoPagoRetido impostoPagoRetido;
//		private BensEDireitos bensEDireitos;
		String dividasOnusPages = service.getDividasOnusPages();
		DividasOnus dividasOnus = DividasOnusUtils.mountDividasOnus(dividasOnusPages);
		
		String paginasResumo = service.getResumoPages();
		ResumoValidator rv = ResumoUtils.mountResumo(paginasResumo);
		DeclaracaoIR dir = new DeclaracaoIR();
		IRValidator irv = new IRValidator();
		irv.setDir(dir);
		if (!rv.isValido()) {
			irv.setValido(false);
		}
		return irv;
	}

	public void setRead(String filePath) throws IOException {
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

	public String getResumoPages() {
		String paginasConcatenadas = "";
		int trueIndexer = this.stringfiedPages.size() - 1;
		for (int i = trueIndexer; i >= 0; i-- ) {
			//Acha a pagina do resumo e concatena ela com todas as páginas q vierem depois, retorna a stringzona
			Pattern pattern = Pattern.compile("((RESUMO)|(resumo))\\s+((TRIBUTAÇÃO\\sUTILIZANDO)|(tributacao\\sutilizando))");
			Matcher matcher = pattern.matcher(this.stringfiedPages.get(i));
			if (matcher.find()) {
				for (int j = i; j <= trueIndexer; j++ ) {
					paginasConcatenadas = paginasConcatenadas.concat(this.stringfiedPages.get(j));
				}
				break;
			}
		}
		return paginasConcatenadas;
	}
	
	public String getRendimentosNaoTributaveisPages() {
		String paginasConcatenadas = "";
		int i = 0;
		int startPage = 0;
		int finalPage = 0;
		for (i = 0; i < this.stringfiedPages.size(); i++ ) {
			Pattern startPattern = Pattern.compile("(RENDIMENTOS\\sISENTOS\\sE\\sNÃO\\sTRIBUTÁVEIS)");
			Matcher startMatcher = startPattern.matcher(this.stringfiedPages.get(i));
			if (startMatcher.find()) {
				startPage = i;
			}
			Pattern finalPattern = Pattern.compile("RENDIMENTOS\\sSUJEITOS\\sÀ\\sTRIBUTAÇÃO\\sEXCLUSIVA\\s\\/\\sDEFINITIVA");
			Matcher finalMatcher = finalPattern.matcher(this.stringfiedPages.get(i));
			if (finalMatcher.find()) {
				finalPage = i;
			}
		}
		for (int j = startPage; j <= finalPage; j++) {
			paginasConcatenadas = paginasConcatenadas.concat(this.stringfiedPages.get(j));
		}
		return paginasConcatenadas;
	}
	public String getRendimentoTributacaoExclusivaPages() {
		String paginasConcatenadas = "";
		int i = 0;
		int startPage = 0;
		int finalPage = 0;
		for (i = 0; i < this.stringfiedPages.size(); i++ ) {
			Pattern startPattern = Pattern.compile("(RENDIMENTOS\\sSUJEITOS\\sÀ\\sTRIBUTAÇÃO\\sEXCLUSIVA\\s\\/\\sDEFINITIVA)");
			Matcher startMatcher = startPattern.matcher(this.stringfiedPages.get(i));
			if (startMatcher.find()) {
				startPage = i;
			}
			Pattern finalPattern = Pattern.compile("(RENDIMENTOS\\sTRIBUTÁVEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sJURÍDICA\\sPELO\\sTITULAR)");
			Matcher finalMatcher = finalPattern.matcher(this.stringfiedPages.get(i));
			if (finalMatcher.find()) {
				finalPage = i;
			}
		}
		for (int j = startPage; j <= finalPage; j++) {
			paginasConcatenadas = paginasConcatenadas.concat(this.stringfiedPages.get(j));
		}
		return paginasConcatenadas;
	}
	public String getDividasOnusPages() {
		String paginasConcatenadas = "";
		int i = 0;
		int startPage = 0;
		int finalPage = 0;
		for (i = 0; i < this.stringfiedPages.size(); i++ ) {
			Pattern startPattern = Pattern.compile("(DÍVIDAS\\sE\\sÔNUS\\sREAIS)");
			Matcher startMatcher = startPattern.matcher(this.stringfiedPages.get(i));
			if (startMatcher.find()) {
				startPage = i;
			}
			Pattern finalPattern = Pattern.compile("(DOAÇÕES\\sA\\sPARTIDOS\\sPOLÍTICOS\\sE\\sCANDIDATOS\\sA\\sCARGOS\\sELETIVOS)");
			Matcher finalMatcher = finalPattern.matcher(this.stringfiedPages.get(i));
			if (finalMatcher.find()) {
				finalPage = i;
			}
		}
		for (int j = startPage; j <= finalPage; j++) {
			paginasConcatenadas = paginasConcatenadas.concat(this.stringfiedPages.get(j));
		}
		return paginasConcatenadas;
	}
	public String getBensDireitosPages() {
		String paginasConcatenadas = "";
		int i = 0;
		int startPage = 0;
		int finalPage = 0;
		for (i = 0; i < this.stringfiedPages.size(); i++ ) {
			Pattern startPattern = Pattern.compile("DECLARAÇÃO DE BENS E DIREITOS");
			Matcher startMatcher = startPattern.matcher(this.stringfiedPages.get(i));
			if (startMatcher.find()) {
				startPage = i;
			}
			Pattern finalPattern = Pattern.compile("(DOAÇÕES\\sA\\sPARTIDOS\\sPOLÍTICOS\\sE\\sCANDIDATOS\\sA\\sCARGOS\\sELETIVOS)");
			Matcher finalMatcher = finalPattern.matcher(this.stringfiedPages.get(i));
			if (finalMatcher.find()) {
				finalPage = i;
			}
		}
		for (int j = startPage; j <= finalPage; j++) {
			paginasConcatenadas = paginasConcatenadas.concat(this.stringfiedPages.get(j));
		}
		return paginasConcatenadas;
	}
}
